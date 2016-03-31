package models;

import beans.BookReviewBean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * BookReviews model class.
 * 
 * @author Skyler Layne on Mar 31, 2016
 *
 */
@XmlRootElement(name = "reviews")
public class BookReviews {
  private List<BookReviewBean> reviews;

  public List<BookReviewBean> getReviews() {
    return reviews;
  }

  @XmlElement(name = "review")
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

  public int size() {
    return this.reviews.size();
  }

}
