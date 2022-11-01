package palchilpalsa.managersystem.domain;

public enum Category {
    CLOTHES("衣類"), SHOES("靴"), ACC("アクセサリー");

    private final String description;

    Category(String description){
        this.description = description;
    }

    public String description() {
        return description;
    }
}
