package models;

import beans.BookReviewBean;

import java.util.ArrayList;
import java.util.List;

public class BookReviews {
  private List<BookReviewBean> reviews;

  public List<BookReviewBean> getReviews() {
    return reviews;
  }

  public void setReviews(List<BookReviewBean> reviews) {
    this.reviews = reviews;
  }

  public BookReviews() {
    this.reviews = new ArrayList<>();
  }

  public BookReviews(List<BookReviewBean> reviews) {
    this.reviews = reviews;
  }

  public BookReviewBean get(int index) {
    return this.reviews.get(index);
  }

  public boolean add(BookReviewBean bean) {
    return this.reviews.add(bean);
  }

}
