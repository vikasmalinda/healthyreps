/**
 * User entity corresponding to table (user1).
 *
 * <p>TODO Confirm the correct user table.
 *
 * @author Aniket
 */
package com.sapient.healthyreps.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user1")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private int user_id;

  @Column(name = "name")
  private String name;

  @Column(name = "height")
  private int height;

  @Column(name = "weight")
  private int weight;

  @Column(name = "dob")
  private Date dob;

  @Column(name = "stars")
  private int stars;

  @NotNull
  @Column(name = "profile_pic")
  private int profile_pic;

  @Column(name = "gender")
  private char gender;

  @Column(name = "contact_no")
  private String contactNo;

  @Column(name = "facebook")
  private String facebook;

  @Column(name = "instagram")
  private String instagram;

  @Column(name = "twitter")
  private String twitter;

  @NotNull
  @Column(name = "email")
  private String email;

  public int getUser_id() {
    return user_id;
  }

  public String getName() {
    return name;
  }

  public int getHeight() {
    return height;
  }

  public int getWeight() {
    return weight;
  }

  public Date getDob() {
    return dob;
  }

  public int getStars() {
    return stars;
  }

  public int getProfile_pic() {
    return profile_pic;
  }

  public char getGender() {
    return gender;
  }

  public String getContactNo() {
    return contactNo;
  }

  public String getFacebook() {
    return facebook;
  }

  public String getInstagram() {
    return instagram;
  }

  public String getTwitter() {
    return twitter;
  }

  public String getEmail() {
    return email;
  }
}
