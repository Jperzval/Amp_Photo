package com.amplifyframework.datastore.generated.model;


import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Photos type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Photos")
@Index(name = "byUser", fields = {"userID"})
public final class Photos implements Model {
  public static final QueryField ID = field("Photos", "id");
  public static final QueryField PRIORITY = field("Photos", "priority");
  public static final QueryField TITLE = field("Photos", "title");
  public static final QueryField USER_ID = field("Photos", "userID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Priority") Priority priority;
  private final @ModelField(targetType="String", isRequired = true) String title;
  private final @ModelField(targetType="ID", isRequired = true) String userID;
  public String getId() {
      return id;
  }
  
  public Priority getPriority() {
      return priority;
  }
  
  public String getTitle() {
      return title;
  }
  
  public String getUserId() {
      return userID;
  }
  
  private Photos(String id, Priority priority, String title, String userID) {
    this.id = id;
    this.priority = priority;
    this.title = title;
    this.userID = userID;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Photos photos = (Photos) obj;
      return ObjectsCompat.equals(getId(), photos.getId()) &&
              ObjectsCompat.equals(getPriority(), photos.getPriority()) &&
              ObjectsCompat.equals(getTitle(), photos.getTitle()) &&
              ObjectsCompat.equals(getUserId(), photos.getUserId());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getPriority())
      .append(getTitle())
      .append(getUserId())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Photos {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("priority=" + String.valueOf(getPriority()) + ", ")
      .append("title=" + String.valueOf(getTitle()) + ", ")
      .append("userID=" + String.valueOf(getUserId()))
      .append("}")
      .toString();
  }
  
  public static TitleStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static Photos justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Photos(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      priority,
      title,
      userID);
  }
  public interface TitleStep {
    UserIdStep title(String title);
  }
  

  public interface UserIdStep {
    BuildStep userId(String userId);
  }
  

  public interface BuildStep {
    Photos build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep priority(Priority priority);
  }
  

  public static class Builder implements TitleStep, UserIdStep, BuildStep {
    private String id;
    private String title;
    private String userID;
    private Priority priority;
    @Override
     public Photos build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Photos(
          id,
          priority,
          title,
          userID);
    }
    
    @Override
     public UserIdStep title(String title) {
        Objects.requireNonNull(title);
        this.title = title;
        return this;
    }
    
    @Override
     public BuildStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.userID = userId;
        return this;
    }
    
    @Override
     public BuildStep priority(Priority priority) {
        this.priority = priority;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, Priority priority, String title, String userId) {
      super.id(id);
      super.title(title)
        .userId(userId)
        .priority(priority);
    }
    
    @Override
     public CopyOfBuilder title(String title) {
      return (CopyOfBuilder) super.title(title);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder priority(Priority priority) {
      return (CopyOfBuilder) super.priority(priority);
    }
  }
  
}
