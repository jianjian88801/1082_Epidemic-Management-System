
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.HuanzheEntity;
import com.entity.MiqiejiechuzheEntity;
import com.entity.view.MiqiejiechuzheView;
import com.service.*;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 密切接触者
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/miqiejiechuzhe")
public class MiqiejiechuzheController {
    private static final Logger logger = LoggerFactory.getLogger(MiqiejiechuzheController.class);

    @Autowired
    private MiqiejiechuzheService miqiejiechuzheService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private HuanzheService huanzheService;

    @Autowired
    private YuangongService yuangongService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = miqiejiechuzheService.queryPage(params);

        //字典表数据转换
        List<MiqiejiechuzheView> list =(List<MiqiejiechuzheView>)page.getList();
        for(MiqiejiechuzheView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MiqiejiechuzheEntity miqiejiechuzhe = miqiejiechuzheService.selectById(id);
        if(miqiejiechuzhe !=null){
            //entity转view
            MiqiejiechuzheView view = new MiqiejiechuzheView();
            BeanUtils.copyProperties( miqiejiechuzhe , view );//把实体数据重构到view中

                //级联表
                HuanzheEntity huanzhe = huanzheService.selectById(miqiejiechuzhe.getHuanzheId());
                if(huanzhe != null){
                    BeanUtils.copyProperties( huanzhe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHuanzheId(huanzhe.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody MiqiejiechuzheEntity miqiejiechuzhe, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,miqiejiechuzhe:{}",this.getClass().getName(),miqiejiechuzhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<MiqiejiechuzheEntity> queryWrapper = new EntityWrapper<MiqiejiechuzheEntity>()
            .eq("huanzhe_id", miqiejiechuzhe.getHuanzheId())
            .eq("miqiejiechuzhe_uuid_number", miqiejiechuzhe.getMiqiejiechuzheUuidNumber())
            .eq("miqiejiechuzhe_geli_address", miqiejiechuzhe.getMiqiejiechuzheGeliAddress())
            .eq("miqiejiechuzhe_geli_types", miqiejiechuzhe.getMiqiejiechuzheGeliTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MiqiejiechuzheEntity miqiejiechuzheEntity = miqiejiechuzheService.selectOne(queryWrapper);
        if(miqiejiechuzheEntity==null){
            miqiejiechuzhe.setInsertTime(new Date());
            miqiejiechuzhe.setCreateTime(new Date());
            miqiejiechuzheService.insert(miqiejiechuzhe);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MiqiejiechuzheEntity miqiejiechuzhe, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,miqiejiechuzhe:{}",this.getClass().getName(),miqiejiechuzhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<MiqiejiechuzheEntity> queryWrapper = new EntityWrapper<MiqiejiechuzheEntity>()
            .notIn("id",miqiejiechuzhe.getId())
            .andNew()
            .eq("huanzhe_id", miqiejiechuzhe.getHuanzheId())
            .eq("miqiejiechuzhe_uuid_number", miqiejiechuzhe.getMiqiejiechuzheUuidNumber())
            .eq("miqiejiechuzhe_geli_address", miqiejiechuzhe.getMiqiejiechuzheGeliAddress())
            .eq("miqiejiechuzhe_geli_types", miqiejiechuzhe.getMiqiejiechuzheGeliTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MiqiejiechuzheEntity miqiejiechuzheEntity = miqiejiechuzheService.selectOne(queryWrapper);
        if(miqiejiechuzheEntity==null){
            miqiejiechuzheService.updateById(miqiejiechuzhe);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        miqiejiechuzheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<MiqiejiechuzheEntity> miqiejiechuzheList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            MiqiejiechuzheEntity miqiejiechuzheEntity = new MiqiejiechuzheEntity();
//                            miqiejiechuzheEntity.setHuanzheId(Integer.valueOf(data.get(0)));   //患者 要改的
//                            miqiejiechuzheEntity.setMiqiejiechuzheUuidNumber(data.get(0));                    //密切接触者编号 要改的
//                            miqiejiechuzheEntity.setMiqiejiechuzheGeliAddress(data.get(0));                    //隔离地址 要改的
//                            miqiejiechuzheEntity.setMiqiejiechuzheGeliTypes(Integer.valueOf(data.get(0)));   //隔离类型 要改的
//                            miqiejiechuzheEntity.setMiqiejiechuzheContent("");//详情和图片
//                            miqiejiechuzheEntity.setGeliTime(sdf.parse(data.get(0)));          //隔离时间 要改的
//                            miqiejiechuzheEntity.setInsertTime(date);//时间
//                            miqiejiechuzheEntity.setCreateTime(date);//时间
                            miqiejiechuzheList.add(miqiejiechuzheEntity);


                            //把要查询是否重复的字段放入map中
                                //密切接触者编号
                                if(seachFields.containsKey("miqiejiechuzheUuidNumber")){
                                    List<String> miqiejiechuzheUuidNumber = seachFields.get("miqiejiechuzheUuidNumber");
                                    miqiejiechuzheUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> miqiejiechuzheUuidNumber = new ArrayList<>();
                                    miqiejiechuzheUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("miqiejiechuzheUuidNumber",miqiejiechuzheUuidNumber);
                                }
                        }

                        //查询是否重复
                         //密切接触者编号
                        List<MiqiejiechuzheEntity> miqiejiechuzheEntities_miqiejiechuzheUuidNumber = miqiejiechuzheService.selectList(new EntityWrapper<MiqiejiechuzheEntity>().in("miqiejiechuzhe_uuid_number", seachFields.get("miqiejiechuzheUuidNumber")));
                        if(miqiejiechuzheEntities_miqiejiechuzheUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MiqiejiechuzheEntity s:miqiejiechuzheEntities_miqiejiechuzheUuidNumber){
                                repeatFields.add(s.getMiqiejiechuzheUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [密切接触者编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        miqiejiechuzheService.insertBatch(miqiejiechuzheList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
