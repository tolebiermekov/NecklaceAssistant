package com.company;

public class SemiPreciousStone extends Stone implements Necklace {
    private int price;
    private int diameter;
    private int height;
    private int density;

    public SemiPreciousStone(int price, int diameter, int height, int density) {
        this.price = price;
        this.diameter = diameter;
        this.height = height;
        this.density = density;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    @Override
    protected int priceInfo() {
        return getPrice();
    }

    @Override
    protected double weightInfo() {
        return Math.pow(getDiameter(), 2) * getHeight() * getDensity() * 0.0016;
    }
    @Override
    public void Necklace() {
        System.out.println("Necklace with Semi Precious stones created. All details you can see below");
    }
}
