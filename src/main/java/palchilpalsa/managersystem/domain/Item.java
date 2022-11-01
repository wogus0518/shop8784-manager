package palchilpalsa.managersystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ITEM")
@Getter
public class Item {
    public Item() {
    }

    public Item(String category, String name, String store, int cost, int price, int medium, int large, int free, int shoes230, int shoes240, int shoes250) {
        this.category = category;
        this.name = name;
        this.store = store;
        this.cost = cost;
        this.price = price;
        this.medium = medium;
        this.large = large;
        this.free = free;
        this.shoes230 = shoes230;
        this.shoes240 = shoes240;
        this.shoes250 = shoes250;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String category; //카테고리
    private String name;     //상품명
    private String store;    //도매상점명
    private int cost;        //도매가
    private int price;       //소매가

    private int medium;
    private int large;
    private int free;
    private int shoes230;
    private int shoes240;
    private int shoes250;
}
