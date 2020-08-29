package cn.smart;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Smart-T
 * @since 16/08/2020
 */
@Data
public class Menu implements Serializable {

    private Integer menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单路径
     */
    private String menuUrl;

    /**
     * 父节点ID
     */
    private Integer fatherId;

    /**
     * 资源类型
     */
    private String sourceType;

    /**
     * 子节点
     */
    private List<Menu> menus;

}
