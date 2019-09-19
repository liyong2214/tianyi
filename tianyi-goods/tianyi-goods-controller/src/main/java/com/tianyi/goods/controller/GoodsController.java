package com.tianyi.goods.controller;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.tianyi.goods.entity.User;
import com.tianyi.goods.service.*;
import com.tianyi.goods.service.realm.AuthRealm;
import com.tianyi.goods.vo.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: tianyi
 * @description: goods 相关接口
 * @author: Simon
 * @create: 2019-09-08 19:29
 **/
@RestController
@RequestMapping("goods")
public class GoodsController {


    @Autowired
    private IGoodsService goodsService;


    @Autowired
    private IGoodsKindService goodsKindService;

    @Autowired
    private IGoodsBrandService goodsBrandService;

    @Autowired
    private ICommodityService commodityService;

    @Autowired
    private IUserService userService;

    @Autowired
    private AuthRealm authRealm;

    /**
     * <h2>添加货品到仓库</h2>
     *
     * @param goodsRequest
     * @return {@link Response}
     */
    @ResponseBody
    @PostMapping("addGoods")
    public Response addGoods(@RequestBody CreateGoodsRequest goodsRequest) {

        return goodsService.addGoods(goodsRequest);
    }


    /**
     * <h2>按照name或者id模糊查询产品</h2>
     *
     * @param createParam
     * @return
     */
    @ResponseBody
    @PostMapping("findGoodsByIdORname")
    public Response selectGoods(@RequestBody CreateParam createParam) {


        return goodsService.findGoodsByIdOrName(createParam.getParam());

    }

    /**
     * <h2>修改产品goods，
     * 注：若修改goods的kindid 会影响对应商品的kindId</h2>
     *
     * @param goodsRequest
     * @return
     */

    @ResponseBody
    @PostMapping("updateGoods")
    public Response updateGoods(@RequestBody UpdateGoodsRequest goodsRequest) {


        return goodsService.updateGoods(goodsRequest);
    }


    /**
     * <h2>依据前端出来的goodid集合删除产品
     * 注：若删除产品会影响商品的上下架状态</h2>
     *
     * @param list 参数集合
     * @return
     */
    @ResponseBody
    @PostMapping("delGoods")
    public Response delGoods(@RequestBody List<CreateParam> list) {
        return goodsService.delGoods(list);
    }


    /**
     * <h2>添加货品类别</h2>
     *
     * @param goodsKindsRequest {@link CreateGoodsKindsRequest}
     * @return {@link Response}
     */
    @ResponseBody
    @PostMapping("addGoodsKind")
    public Response addGoodsKind(@RequestBody CreateGoodsKindsRequest goodsKindsRequest) {

        return goodsKindService.addGoodskind(goodsKindsRequest);
    }

    /**
     * <h2>根据传来的pid查询商品类别</h2>
     *
     * @param createParam {@link CreateParam}
     * @return
     */
    @ResponseBody
    @PostMapping("findGoodsKindByPid")
    public Response selectGoodsKindByPid(@RequestBody CreateParam createParam) {


        return goodsKindService.findGoodskindByPid(createParam);
    }

    /**
     * <h2>根据传来的类别id查询商品类别</h2>
     *
     * @param createParam {@link CreateParam}
     * @return
     */

    @ResponseBody
    @PostMapping("findGoodsKindById")
    public Response selectGoodsKindById(@RequestBody CreateParam createParam) {

        return goodsKindService.findGoodsKindById(createParam);
    }

    /**
     * <h2>修改商品类型信息</h2>
     *
     * @param goodsKindsRequest {@link UpdateGoodsKindsRequest}
     * @return
     */
    @ResponseBody
    @PostMapping("updateGoodsKind")
    public Response updateGoodsKind(@RequestBody UpdateGoodsKindsRequest goodsKindsRequest) {

        return goodsKindService.updateGoodsKind(goodsKindsRequest);
    }


    /**
     * <h2>删除商品类别</h2>
     *
     * @param createParam
     * @return
     */

    @ResponseBody
    @PostMapping("delGoodsKind")
    public Response delGoodsKind(@RequestBody CreateParam createParam) {

        return goodsKindService.delGoodsKind(createParam);
    }


    /**
     * <h2>添加产品品牌</h2>
     *
     * @param goodsBrandRequest {@link CreateGoodsBrandRequest}
     * @return {@link Response}
     */
    @ResponseBody
    @PostMapping("addGoodsBrand")
    public Response addGoodsBrand(@RequestBody CreateGoodsBrandRequest goodsBrandRequest) {

        return goodsBrandService.addBrand(goodsBrandRequest);
    }


    /**
     * <h2>依据传来的id或者name查询品牌</h2>
     *
     * @param createParam {@link CreateParam 参数vo}
     * @return
     */
    @ResponseBody
    @PostMapping("findGoodsBrand")
    public Response selectGoodsBrand(@RequestBody CreateParam createParam) {

        return goodsBrandService.findBrand(createParam);
    }


    /**
     * <h2>更新品牌信息</h2>
     *
     * @param goodsBrandRequest {@link UpdateGoodsBrandRequest 更新品牌信息}
     * @return
     */
    @ResponseBody
    @PostMapping("updateGoodsBrand")
    public Response updateGoodsBrand(@RequestBody UpdateGoodsBrandRequest goodsBrandRequest) {


        return goodsBrandService.updateBrand(goodsBrandRequest);
    }


    /**
     * <h2>删除goods品牌</h2>
     *
     * @param list
     * @return
     */

    @ResponseBody
    @PostMapping("delGoodsBrand")
    public Response delGoodsBrand(@RequestBody List<CreateParam> list) {

        return goodsBrandService.delBrand(list);
    }


    @ResponseBody
    @PostMapping("test")
    public Response test() {


        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(authRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);


        // 从SecurityUtils里边创建一个subject
        Subject subject = SecurityUtils.getSubject();

        // 在认证提交前准备token（令牌）
        // 这里的账号和密码 将来是由用户输入进去
        UsernamePasswordToken token = new UsernamePasswordToken("tiezhu", "123456");

        try {
            // 执行认证提交
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        // 是否认证通过
        boolean isAuthenticated = subject.isAuthenticated();

        System.out.println("是否认证通过：" + isAuthenticated);
//        subject.checkRole("采购");

        if (isAuthenticated) {
            User user = userService.selectUserByAccount("tiezhu", "123456");
            System.out.println(user);
            Session session = subject.getSession();
            session.setAttribute("userId" + user.getUserId(), user);
        }


        System.out.println("采购执行" + subject.hasRole("采购"));
        System.out.println("销售权限" + subject.isPermitted("销售权限"));

        // 退出操作
        subject.logout();


        // 是否认证通过
        isAuthenticated = subject.isAuthenticated();

        System.out.println("是否认证通过：" + isAuthenticated);

        return new Response();

    }


}
