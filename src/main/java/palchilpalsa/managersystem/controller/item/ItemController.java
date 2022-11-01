package palchilpalsa.managersystem.controller.item;

import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import palchilpalsa.managersystem.domain.Category;
import palchilpalsa.managersystem.domain.Item;
import palchilpalsa.managersystem.service.ItemService;
import palchilpalsa.managersystem.service.QrCodeService;
import palchilpalsa.managersystem.web.dto.item.AddItemDto;

import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final QrCodeService qrCodeService;

    @ModelAttribute("categories")
    public Category[] categories() {
        return Category.values();
    }

    @GetMapping("/add")
    public String addView(@ModelAttribute AddItemDto addItemDto) {
        return "item/add";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute AddItemDto addItemDto,
                      BindingResult bindingResult) throws IOException, WriterException {
        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "item/add";
        }
        Item item = new Item(addItemDto.getCategory(), addItemDto.getName(), addItemDto.getStore(), addItemDto.getCost(), addItemDto.getPrice(), addItemDto.getMedium(), addItemDto.getLarge(), addItemDto.getFree(), addItemDto.getShoes230(), addItemDto.getShoes240(), addItemDto.getShoes250());
        Long itemId = itemService.addItem(item);

        return "redirect:/item/confirm/"+itemId;
    }

    @GetMapping("/confirm/{itemId}")
    public String confirm(@PathVariable Long itemId, Model model) {
        String base64 = qrCodeService.getBase64(itemId);
        model.addAttribute("base64", base64);

        Item item = itemService.findOne(itemId);
        model.addAttribute("item", item);
        return "item/confirm";
    }
}
