package cn.smart.other;

import cn.smart.Menu;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 一些常见的实用工具
 *
 * @author Smart-T
 * @since 16/08/2020
 */
public class OtherUtils {

    /**
     * 树形生成：递归
     * @param menus 当前所有菜单的集合
     * @param fatherId 父级菜单ID
     * @return 迭代好的树
     */
    public List<Menu> getMenusTree(List<Menu> menus, Integer fatherId) {
        //新建一个数据用于装每一个迭代好的一条树
        List<Menu> tree = new ArrayList<>();
        menus.forEach(menu -> {
            //判断是否还有子菜单
            if (menu != null && StringUtils.equals(fatherId + "", menu.getFatherId() + "")) {
                menu.setMenus(getMenusTree(menus, menu.getMenuId()));
                tree.add(menu);
            }
        });
        return tree;
    }
}
