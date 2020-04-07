package cn.smart.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult {

    //结果集
    private List<TbItem> result;

    //当前页
    private Integer pageIndex;

    //总页数
    private Long totalPage;

    //总条数
    private Long totalNum;
}
