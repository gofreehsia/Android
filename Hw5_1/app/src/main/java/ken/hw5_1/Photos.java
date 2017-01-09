package ken.hw5_1;

/**
 * Created by PC-26 on 2017/1/6.
 */

public class Photos {
    private int imageId;
    private String name;
    private String price;

    public Photos(int imageId, String name, String price) {
        this.imageId = imageId;
        this.name = name;
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
