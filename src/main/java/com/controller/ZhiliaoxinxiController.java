
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.HuanzheEntity;
import com.entity.ZhiliaoxinxiEntity;
import com.entity.view.ZhiliaoxinxiView;
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
 * 治疗信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhiliaoxinxi")
public class ZhiliaoxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(ZhiliaoxinxiController.class);

    @Autowired
    private ZhiliaoxinxiService zhiliaoxinxiService;


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
        PageUtils page = zhiliaoxinxiService.queryPage(params);

        //字典表数据转换
        List<ZhiliaoxinxiView> list =(List<ZhiliaoxinxiView>)page.getList();
        for(ZhiliaoxinxiView c:list){
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
        ZhiliaoxinxiEntity zhiliaoxinxi = zhiliaoxinxiService.selectById(id);
        if(zhiliaoxinxi !=null){
            //entity转view
            ZhiliaoxinxiView view = new ZhiliaoxinxiView();
            BeanUtils.copyProperties( zhiliaoxinxi , view );//把实体数据重构到view中

                //级联表
                HuanzheEntity huanzhe = huanzheService.selectById(zhiliaoxinxi.getHuanzheId());
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
    public R save(@RequestBody ZhiliaoxinxiEntity zhiliaoxinxi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhiliaoxinxi:{}",this.getClass().getName(),zhiliaoxinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhiliaoxinxiEntity> queryWrapper = new EntityWrapper<ZhiliaoxinxiEntity>()
            .eq("huanzhe_id", zhiliaoxinxi.getHuanzheId())
            .eq("zhiliaoxinxi_uuid_number", zhiliaoxinxi.getZhiliaoxinxiUuidNumber())
            .eq("ganranyuan", zhiliaoxinxi.getGanranyuan())
            .eq("zhongzheng_types", zhiliaoxinxi.getZhongzhengTypes())
            .eq("fabing_zhengzhuang", zhiliaoxinxi.getFabingZhengzhuang())
            .eq("zhenzhiyiyuan", zhiliaoxinxi.getZhenzhiyiyuan())
            .eq("hesuanjiance_text", zhiliaoxinxi.getHesuanjianceText())
            .eq("ctjiance_text", zhiliaoxinxi.getCtjianceText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhiliaoxinxiEntity zhiliaoxinxiEntity = zhiliaoxinxiService.selectOne(queryWrapper);
        if(zhiliaoxinxiEntity==null){
            zhiliaoxinxi.setInsertTime(new Date());
            zhiliaoxinxi.setCreateTime(new Date());
            zhiliaoxinxiService.insert(zhiliaoxinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhiliaoxinxiEntity zhiliaoxinxi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhiliaoxinxi:{}",this.getClass().getName(),zhiliaoxinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ZhiliaoxinxiEntity> queryWrapper = new EntityWrapper<ZhiliaoxinxiEntity>()
            .notIn("id",zhiliaoxinxi.getId())
            .andNew()
            .eq("huanzhe_id", zhiliaoxinxi.getHuanzheId())
            .eq("zhiliaoxinxi_uuid_number", zhiliaoxinxi.getZhiliaoxinxiUuidNumber())
            .eq("ganranyuan", zhiliaoxinxi.getGanranyuan())
            .eq("zhongzheng_types", zhiliaoxinxi.getZhongzhengTypes())
            .eq("fabing_zhengzhuang", zhiliaoxinxi.getFabingZhengzhuang())
            .eq("zhenzhiyiyuan", zhiliaoxinxi.getZhenzhiyiyuan())
            .eq("hesuanjiance_text", zhiliaoxinxi.getHesuanjianceText())
            .eq("ctjiance_text", zhiliaoxinxi.getCtjianceText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhiliaoxinxiEntity zhiliaoxinxiEntity = zhiliaoxinxiService.selectOne(queryWrapper);
        if(zhiliaoxinxiEntity==null){
            zhiliaoxinxiService.updateById(zhiliaoxinxi);//根据id更新
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
        zhiliaoxinxiService.deleteBatchIds(Arrays.asList(ids));
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
            List<ZhiliaoxinxiEntity> zhiliaoxinxiList = new ArrayList<>();//上传的东西
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
                            ZhiliaoxinxiEntity zhiliaoxinxiEntity = new ZhiliaoxinxiEntity();
//                            zhiliaoxinxiEntity.setHuanzheId(Integer.valueOf(data.get(0)));   //患者 要改的
//                            zhiliaoxinxiEntity.setZhiliaoxinxiUuidNumber(data.get(0));                    //治疗信息编号 要改的
//                            zhiliaoxinxiEntity.setGanranyuan(data.get(0));                    //感染源 要改的
//                            zhiliaoxinxiEntity.setZhongzhengTypes(Integer.valueOf(data.get(0)));   //是否重症 要改的
//                            zhiliaoxinxiEntity.setZhuyuanTime(sdf.parse(data.get(0)));          //住院时间 要改的
//                            zhiliaoxinxiEntity.setFabingZhengzhuang(data.get(0));                    //发病症状 要改的
//                            zhiliaoxinxiEntity.setZhenzhiyiyuan(data.get(0));                    //诊治医院 要改的
//                            zhiliaoxinxiEntity.setHesuanjianceText(data.get(0));                    //核酸检测 要改的
//                            zhiliaoxinxiEntity.setCtjianceText(data.get(0));                    //CT检测史 要改的
//                            zhiliaoxinxiEntity.setZhiliaoxinxiContent("");//详情和图片
//                            zhiliaoxinxiEntity.setInsertTime(date);//时间
//                            zhiliaoxinxiEntity.setCreateTime(date);//时间
                            zhiliaoxinxiList.add(zhiliaoxinxiEntity);


                            //把要查询是否重复的字段放入map中
                                //治疗信息编号
                                if(seachFields.containsKey("zhiliaoxinxiUuidNumber")){
                                    List<String> zhiliaoxinxiUuidNumber = seachFields.get("zhiliaoxinxiUuidNumber");
                                    zhiliaoxinxiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhiliaoxinxiUuidNumber = new ArrayList<>();
                                    zhiliaoxinxiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zhiliaoxinxiUuidNumber",zhiliaoxinxiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //治疗信息编号
                        List<ZhiliaoxinxiEntity> zhiliaoxinxiEntities_zhiliaoxinxiUuidNumber = zhiliaoxinxiService.selectList(new EntityWrapper<ZhiliaoxinxiEntity>().in("zhiliaoxinxi_uuid_number", seachFields.get("zhiliaoxinxiUuidNumber")));
                        if(zhiliaoxinxiEntities_zhiliaoxinxiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhiliaoxinxiEntity s:zhiliaoxinxiEntities_zhiliaoxinxiUuidNumber){
                                repeatFields.add(s.getZhiliaoxinxiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [治疗信息编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhiliaoxinxiService.insertBatch(zhiliaoxinxiList);
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
