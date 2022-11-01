package palchilpalsa.managersystem.controller.item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ListController {

    @GetMapping("/list")
    public String list() {

        return "item/list";
    }

}
