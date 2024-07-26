
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.HuanzheEntity;
import com.entity.ZhiyuhuanzheEntity;
import com.entity.view.ZhiyuhuanzheView;
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
 * 治愈患者
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhiyuhuanzhe")
public class ZhiyuhuanzheController {
    private static final Logger logger = LoggerFactory.getLogger(ZhiyuhuanzheController.class);

    @Autowired
    private ZhiyuhuanzheService zhiyuhuanzheService;


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
        PageUtils page = zhiyuhuanzheService.queryPage(params);

        //字典表数据转换
        List<ZhiyuhuanzheView> list =(List<ZhiyuhuanzheView>)page.getList();
        for(ZhiyuhuanzheView c:list){
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
        ZhiyuhuanzheEntity zhiyuhuanzhe = zhiyuhuanzheService.selectById(id);
        if(zhiyuhuanzhe !=null){
            //entity转view
            ZhiyuhuanzheView view = new ZhiyuhuanzheView();
            BeanUtils.copyProperties( zhiyuhuanzhe , view );//把实体数据重构到view中

                //级联表
                HuanzheEntity huanzhe = huanzheService.selectById(zhiyuhuanzhe.getHuanzheId());
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
    public R save(@RequestBody ZhiyuhuanzheEntity zhiyuhuanzhe, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhiyuhuanzhe:{}",this.getClass().getName(),zhiyuhuanzhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhiyuhuanzheEntity> queryWrapper = new EntityWrapper<ZhiyuhuanzheEntity>()
            .eq("huanzhe_id", zhiyuhuanzhe.getHuanzheId())
            .eq("zhiyuhuanzhe_uuid_number", zhiyuhuanzhe.getZhiyuhuanzheUuidNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhiyuhuanzheEntity zhiyuhuanzheEntity = zhiyuhuanzheService.selectOne(queryWrapper);
        if(zhiyuhuanzheEntity==null){
            zhiyuhuanzhe.setInsertTime(new Date());
            zhiyuhuanzhe.setCreateTime(new Date());
            zhiyuhuanzheService.insert(zhiyuhuanzhe);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhiyuhuanzheEntity zhiyuhuanzhe, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhiyuhuanzhe:{}",this.getClass().getName(),zhiyuhuanzhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ZhiyuhuanzheEntity> queryWrapper = new EntityWrapper<ZhiyuhuanzheEntity>()
            .notIn("id",zhiyuhuanzhe.getId())
            .andNew()
            .eq("huanzhe_id", zhiyuhuanzhe.getHuanzheId())
            .eq("zhiyuhuanzhe_uuid_number", zhiyuhuanzhe.getZhiyuhuanzheUuidNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhiyuhuanzheEntity zhiyuhuanzheEntity = zhiyuhuanzheService.selectOne(queryWrapper);
        if(zhiyuhuanzheEntity==null){
            zhiyuhuanzheService.updateById(zhiyuhuanzhe);//根据id更新
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
        zhiyuhuanzheService.deleteBatchIds(Arrays.asList(ids));
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
            List<ZhiyuhuanzheEntity> zhiyuhuanzheList = new ArrayList<>();//上传的东西
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
                            ZhiyuhuanzheEntity zhiyuhuanzheEntity = new ZhiyuhuanzheEntity();
//                            zhiyuhuanzheEntity.setHuanzheId(Integer.valueOf(data.get(0)));   //患者 要改的
//                            zhiyuhuanzheEntity.setZhiyuhuanzheUuidNumber(data.get(0));                    //治愈患者编号 要改的
//                            zhiyuhuanzheEntity.setZhiyuhuanzheContent("");//详情和图片
//                            zhiyuhuanzheEntity.setQuezhenTime(sdf.parse(data.get(0)));          //治愈时间 要改的
//                            zhiyuhuanzheEntity.setInsertTime(date);//时间
//                            zhiyuhuanzheEntity.setCreateTime(date);//时间
                            zhiyuhuanzheList.add(zhiyuhuanzheEntity);


                            //把要查询是否重复的字段放入map中
                                //治愈患者编号
                                if(seachFields.containsKey("zhiyuhuanzheUuidNumber")){
                                    List<String> zhiyuhuanzheUuidNumber = seachFields.get("zhiyuhuanzheUuidNumber");
                                    zhiyuhuanzheUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhiyuhuanzheUuidNumber = new ArrayList<>();
                                    zhiyuhuanzheUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zhiyuhuanzheUuidNumber",zhiyuhuanzheUuidNumber);
                                }
                        }

                        //查询是否重复
                         //治愈患者编号
                        List<ZhiyuhuanzheEntity> zhiyuhuanzheEntities_zhiyuhuanzheUuidNumber = zhiyuhuanzheService.selectList(new EntityWrapper<ZhiyuhuanzheEntity>().in("zhiyuhuanzhe_uuid_number", seachFields.get("zhiyuhuanzheUuidNumber")));
                        if(zhiyuhuanzheEntities_zhiyuhuanzheUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhiyuhuanzheEntity s:zhiyuhuanzheEntities_zhiyuhuanzheUuidNumber){
                                repeatFields.add(s.getZhiyuhuanzheUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [治愈患者编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhiyuhuanzheService.insertBatch(zhiyuhuanzheList);
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
