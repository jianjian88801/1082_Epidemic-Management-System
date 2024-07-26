
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.HuanzheEntity;
import com.entity.QuezhenhuanzheEntity;
import com.entity.SiwanghuanzheEntity;
import com.entity.ZhiyuhuanzheEntity;
import com.entity.view.QuezhenhuanzheView;
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
 * 确诊患者
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/quezhenhuanzhe")
public class QuezhenhuanzheController {
    private static final Logger logger = LoggerFactory.getLogger(QuezhenhuanzheController.class);

    @Autowired
    private QuezhenhuanzheService quezhenhuanzheService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private HuanzheService huanzheService;

    @Autowired
    private YuangongService yuangongService;

    @Autowired
    private SiwanghuanzheService siwanghuanzheService;

    @Autowired
    private ZhiyuhuanzheService zhiyuhuanzheService;


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
        PageUtils page = quezhenhuanzheService.queryPage(params);

        //字典表数据转换
        List<QuezhenhuanzheView> list =(List<QuezhenhuanzheView>)page.getList();
        for(QuezhenhuanzheView c:list){
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
        QuezhenhuanzheEntity quezhenhuanzhe = quezhenhuanzheService.selectById(id);
        if(quezhenhuanzhe !=null){
            //entity转view
            QuezhenhuanzheView view = new QuezhenhuanzheView();
            BeanUtils.copyProperties( quezhenhuanzhe , view );//把实体数据重构到view中

                //级联表
                HuanzheEntity huanzhe = huanzheService.selectById(quezhenhuanzhe.getHuanzheId());
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
    public R save(@RequestBody QuezhenhuanzheEntity quezhenhuanzhe, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,quezhenhuanzhe:{}",this.getClass().getName(),quezhenhuanzhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<QuezhenhuanzheEntity> queryWrapper = new EntityWrapper<QuezhenhuanzheEntity>()
            .eq("huanzhe_id", quezhenhuanzhe.getHuanzheId())
            .eq("quezhenhuanzhe_uuid_number", quezhenhuanzhe.getQuezhenhuanzheUuidNumber())
            .eq("quezhenhuanzhe_geli_address", quezhenhuanzhe.getQuezhenhuanzheGeliAddress())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QuezhenhuanzheEntity quezhenhuanzheEntity = quezhenhuanzheService.selectOne(queryWrapper);
        if(quezhenhuanzheEntity==null){
            quezhenhuanzhe.setInsertTime(new Date());
            quezhenhuanzhe.setCreateTime(new Date());
            quezhenhuanzheService.insert(quezhenhuanzhe);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QuezhenhuanzheEntity quezhenhuanzhe, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,quezhenhuanzhe:{}",this.getClass().getName(),quezhenhuanzhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<QuezhenhuanzheEntity> queryWrapper = new EntityWrapper<QuezhenhuanzheEntity>()
            .notIn("id",quezhenhuanzhe.getId())
            .andNew()
            .eq("huanzhe_id", quezhenhuanzhe.getHuanzheId())
            .eq("quezhenhuanzhe_uuid_number", quezhenhuanzhe.getQuezhenhuanzheUuidNumber())
            .eq("quezhenhuanzhe_geli_address", quezhenhuanzhe.getQuezhenhuanzheGeliAddress())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QuezhenhuanzheEntity quezhenhuanzheEntity = quezhenhuanzheService.selectOne(queryWrapper);
        if(quezhenhuanzheEntity==null){
            quezhenhuanzheService.updateById(quezhenhuanzhe);//根据id更新
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
        quezhenhuanzheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
     * 转死亡
     */
    @RequestMapping("/zhuansiwang")
    public R zhuansiwang(@RequestParam("id") Integer id){
        logger.debug("zhuansiwang:,,Controller:{},,id:{}",this.getClass().getName(),id);

        QuezhenhuanzheEntity quezhenhuanzheEntity = quezhenhuanzheService.selectById(id);
        if(quezhenhuanzheEntity == null)
            return R.error("查不到确诊患者记录");

        SiwanghuanzheEntity siwanghuanzheEntity = new SiwanghuanzheEntity();
        siwanghuanzheEntity.setCreateTime(new Date());
        siwanghuanzheEntity.setInsertTime(new Date());
        siwanghuanzheEntity.setHuanzheId(quezhenhuanzheEntity.getHuanzheId());
        siwanghuanzheEntity.setQuezhenTime(new Date());
        siwanghuanzheEntity.setSiwanghuanzheContent("");
        siwanghuanzheEntity.setSiwanghuanzheUuidNumber(String.valueOf(new Date().getTime()));
        siwanghuanzheService.insert(siwanghuanzheEntity);
        quezhenhuanzheService.deleteById(id);
        return R.ok();
    }


    /**
     * 转治愈
     */
    @RequestMapping("/zhuanzhiyu")
    public R zhuanzhiyu(@RequestParam("id") Integer id){
        logger.debug("zhuanzhiyu:,,Controller:{},,id:{}",this.getClass().getName(),id);

        QuezhenhuanzheEntity quezhenhuanzheEntity = quezhenhuanzheService.selectById(id);
        if(quezhenhuanzheEntity == null)
            return R.error("查不到确诊患者记录");

        ZhiyuhuanzheEntity zhiyuhuanzheEntity = new ZhiyuhuanzheEntity();
        zhiyuhuanzheEntity.setCreateTime(new Date());
        zhiyuhuanzheEntity.setInsertTime(new Date());
        zhiyuhuanzheEntity.setHuanzheId(quezhenhuanzheEntity.getHuanzheId());
        zhiyuhuanzheEntity.setQuezhenTime(new Date());
        zhiyuhuanzheEntity.setZhiyuhuanzheContent("");
        zhiyuhuanzheEntity.setZhiyuhuanzheUuidNumber(String.valueOf(new Date().getTime()));
        zhiyuhuanzheService.insert(zhiyuhuanzheEntity);
        quezhenhuanzheService.deleteById(id);
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
            List<QuezhenhuanzheEntity> quezhenhuanzheList = new ArrayList<>();//上传的东西
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
                            QuezhenhuanzheEntity quezhenhuanzheEntity = new QuezhenhuanzheEntity();
//                            quezhenhuanzheEntity.setHuanzheId(Integer.valueOf(data.get(0)));   //患者 要改的
//                            quezhenhuanzheEntity.setQuezhenhuanzheUuidNumber(data.get(0));                    //确诊患者编号 要改的
//                            quezhenhuanzheEntity.setQuezhenhuanzheGeliAddress(data.get(0));                    //确诊位置 要改的
//                            quezhenhuanzheEntity.setQuezhenhuanzheContent("");//详情和图片
//                            quezhenhuanzheEntity.setQuezhenTime(sdf.parse(data.get(0)));          //确诊时间 要改的
//                            quezhenhuanzheEntity.setInsertTime(date);//时间
//                            quezhenhuanzheEntity.setCreateTime(date);//时间
                            quezhenhuanzheList.add(quezhenhuanzheEntity);


                            //把要查询是否重复的字段放入map中
                                //确诊患者编号
                                if(seachFields.containsKey("quezhenhuanzheUuidNumber")){
                                    List<String> quezhenhuanzheUuidNumber = seachFields.get("quezhenhuanzheUuidNumber");
                                    quezhenhuanzheUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> quezhenhuanzheUuidNumber = new ArrayList<>();
                                    quezhenhuanzheUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("quezhenhuanzheUuidNumber",quezhenhuanzheUuidNumber);
                                }
                        }

                        //查询是否重复
                         //确诊患者编号
                        List<QuezhenhuanzheEntity> quezhenhuanzheEntities_quezhenhuanzheUuidNumber = quezhenhuanzheService.selectList(new EntityWrapper<QuezhenhuanzheEntity>().in("quezhenhuanzhe_uuid_number", seachFields.get("quezhenhuanzheUuidNumber")));
                        if(quezhenhuanzheEntities_quezhenhuanzheUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(QuezhenhuanzheEntity s:quezhenhuanzheEntities_quezhenhuanzheUuidNumber){
                                repeatFields.add(s.getQuezhenhuanzheUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [确诊患者编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        quezhenhuanzheService.insertBatch(quezhenhuanzheList);
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
