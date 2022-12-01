package com.sood.rahul.entities;

import com.sood.rahul.calculator.CalculateTicketPrice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Showing {
    private Movie movie;
    private int sequenceOfTheDay;
    private List<Double> discounts = new ArrayList<>(8);
    private LocalDateTime showStartTime;
    private double discountedPriceForShowing;

    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
        discounts.add(0.0);
    }

    public LocalDateTime getShowStartTime() {
        return showStartTime;
    }
    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    public boolean isSequence(int sequence) {
        return this.sequenceOfTheDay == sequence;
    }

    public double getMovieFee() {
        return movie.getTicketPrice();
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    private double calculateFee(int audienceCount) {
        return movie.calculateTicketPrice(this) * audienceCount;
    }

    public double getDiscountedPriceForShowing() {
        return CalculateTicketPrice.getTicketPrice(this).discountedPriceForShowing;
    }

    public void setDiscountedPriceForShowing(double discountedPriceForShowing) {
        this.discountedPriceForShowing = discountedPriceForShowing;
    }

    public List<Double> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Double> discounts) {
        this.discounts = discounts;
    }
}
