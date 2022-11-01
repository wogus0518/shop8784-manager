package palchilpalsa.managersystem.service;

import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import palchilpalsa.managersystem.domain.Item;
import palchilpalsa.managersystem.domain.QrCode;
import palchilpalsa.managersystem.repository.ItemRepository;
import palchilpalsa.managersystem.repository.QrCodeRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final QrCodeService qrCodeService;
    private final QrCodeRepository qrCodeRepository;

    public Long addItem(Item item) throws IOException, WriterException {
        Long itemId = itemRepository.save(item);
        String base64 = qrCodeService.createQr(itemId).toString();

        QrCode qrCode = new QrCode(itemId, base64);
        qrCodeRepository.save(qrCode);
        return itemId;
    }

    public Item findOne(Long id) {
        return itemRepository.findById(id);
    }
}
