package entity;

public class Goods implements Comparable<Goods> {
    private int id;
    private String name;
    private String type;
    private double price;
    private int num;
    private String evaluate;

    public Goods() {
    }

    public Goods(int id, String name, String type, double price, int num, String evaluate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.num = num;
        this.evaluate = evaluate;
    }

    public Goods(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Goods(int id, String name, int num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "编号：" + id +
                ", 名字：'" + name + '\'' +
                ", 种类：'" + type + '\'' +
                ", 价格：" + price +
                ", 剩余数量：" + num +
                ", 评价：'" + evaluate + '\'' +
                '}';
    }

    @Override
    public int compareTo(Goods o) {
        if (id > o.id) {
            return 1;
        } else if (id == o.id) {
            return 0;
        } else {
            return -1;
        }
    }
}
