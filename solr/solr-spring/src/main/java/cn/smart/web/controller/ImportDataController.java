package cn.smart.web.controller;

import cn.smart.service.ImportItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/import")
public class ImportDataController {

    @Autowired
    private ImportItemService importItemService;

    @RequestMapping("importData")
    @ResponseBody
    public String importData(){
        this.importItemService.importItem();
        return "OK!!!";
    }

}
