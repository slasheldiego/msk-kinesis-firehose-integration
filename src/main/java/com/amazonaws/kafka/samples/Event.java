/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.amazonaws.kafka.samples;
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Event extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Event\",\"namespace\":\"com.amazonaws.kafka.samples\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"date\",\"type\":\"string\"},{\"name\":\"quantity\",\"type\":\"int\"},{\"name\":\"unitPrice\",\"type\":\"double\"},{\"name\":\"customerId\",\"type\":\"long\"},{\"name\":\"country\",\"type\":\"string\"},{\"name\":\"description\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public long id;
  @Deprecated public java.lang.CharSequence date;
  @Deprecated public int quantity;
  @Deprecated public double unitPrice;
  @Deprecated public long customerId;
  @Deprecated public java.lang.CharSequence country;
  @Deprecated public java.lang.CharSequence description;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Event() {}

  /**
   * All-args constructor.
   */
  public Event(java.lang.Long id, java.lang.CharSequence date, java.lang.Integer quantity, java.lang.Double unitPrice, java.lang.Long customerId, java.lang.CharSequence country, java.lang.CharSequence description) {
    this.id = id;
    this.date = date;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
    this.customerId = customerId;
    this.country = country;
    this.description = description;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return date;
    case 2: return quantity;
    case 3: return unitPrice;
    case 4: return customerId;
    case 5: return country;
    case 6: return description;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Long)value$; break;
    case 1: date = (java.lang.CharSequence)value$; break;
    case 2: quantity = (java.lang.Integer)value$; break;
    case 3: unitPrice = (java.lang.Double)value$; break;
    case 4: customerId = (java.lang.Long)value$; break;
    case 5: country = (java.lang.CharSequence)value$; break;
    case 6: description = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.Long value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'date' field.
   */
  public java.lang.CharSequence getDate() {
    return date;
  }

  /**
   * Sets the value of the 'date' field.
   * @param value the value to set.
   */
  public void setDate(java.lang.CharSequence value) {
    this.date = value;
  }

  /**
   * Gets the value of the 'quantity' field.
   */
  public java.lang.Integer getQuantity() {
    return quantity;
  }

  /**
   * Sets the value of the 'quantity' field.
   * @param value the value to set.
   */
  public void setQuantity(java.lang.Integer value) {
    this.quantity = value;
  }

  /**
   * Gets the value of the 'unitPrice' field.
   */
  public java.lang.Double getUnitPrice() {
    return unitPrice;
  }

  /**
   * Sets the value of the 'unitPrice' field.
   * @param value the value to set.
   */
  public void setUnitPrice(java.lang.Double value) {
    this.unitPrice = value;
  }

  /**
   * Gets the value of the 'customerId' field.
   */
  public java.lang.Long getCustomerId() {
    return customerId;
  }

  /**
   * Sets the value of the 'customerId' field.
   * @param value the value to set.
   */
  public void setCustomerId(java.lang.Long value) {
    this.customerId = value;
  }

  /**
   * Gets the value of the 'country' field.
   */
  public java.lang.CharSequence getCountry() {
    return country;
  }

  /**
   * Sets the value of the 'country' field.
   * @param value the value to set.
   */
  public void setCountry(java.lang.CharSequence value) {
    this.country = value;
  }

  /**
   * Gets the value of the 'description' field.
   */
  public java.lang.CharSequence getDescription() {
    return description;
  }

  /**
   * Sets the value of the 'description' field.
   * @param value the value to set.
   */
  public void setDescription(java.lang.CharSequence value) {
    this.description = value;
  }

  /** Creates a new Event RecordBuilder */
  public static com.amazonaws.kafka.samples.Event.Builder newBuilder() {
    return new com.amazonaws.kafka.samples.Event.Builder();
  }
  
  /** Creates a new Event RecordBuilder by copying an existing Builder */
  public static com.amazonaws.kafka.samples.Event.Builder newBuilder(com.amazonaws.kafka.samples.Event.Builder other) {
    return new com.amazonaws.kafka.samples.Event.Builder(other);
  }
  
  /** Creates a new Event RecordBuilder by copying an existing Event instance */
  public static com.amazonaws.kafka.samples.Event.Builder newBuilder(com.amazonaws.kafka.samples.Event other) {
    return new com.amazonaws.kafka.samples.Event.Builder(other);
  }
  
  /**
   * RecordBuilder for Event instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Event>
    implements org.apache.avro.data.RecordBuilder<Event> {

    private long id;
    private java.lang.CharSequence date;
    private int quantity;
    private double unitPrice;
    private long customerId;
    private java.lang.CharSequence country;
    private java.lang.CharSequence description;

    /** Creates a new Builder */
    private Builder() {
      super(com.amazonaws.kafka.samples.Event.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.amazonaws.kafka.samples.Event.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.date)) {
        this.date = data().deepCopy(fields()[1].schema(), other.date);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.quantity)) {
        this.quantity = data().deepCopy(fields()[2].schema(), other.quantity);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.unitPrice)) {
        this.unitPrice = data().deepCopy(fields()[3].schema(), other.unitPrice);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.customerId)) {
        this.customerId = data().deepCopy(fields()[4].schema(), other.customerId);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.country)) {
        this.country = data().deepCopy(fields()[5].schema(), other.country);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.description)) {
        this.description = data().deepCopy(fields()[6].schema(), other.description);
        fieldSetFlags()[6] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Event instance */
    private Builder(com.amazonaws.kafka.samples.Event other) {
            super(com.amazonaws.kafka.samples.Event.SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.date)) {
        this.date = data().deepCopy(fields()[1].schema(), other.date);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.quantity)) {
        this.quantity = data().deepCopy(fields()[2].schema(), other.quantity);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.unitPrice)) {
        this.unitPrice = data().deepCopy(fields()[3].schema(), other.unitPrice);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.customerId)) {
        this.customerId = data().deepCopy(fields()[4].schema(), other.customerId);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.country)) {
        this.country = data().deepCopy(fields()[5].schema(), other.country);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.description)) {
        this.description = data().deepCopy(fields()[6].schema(), other.description);
        fieldSetFlags()[6] = true;
      }
    }

    /** Gets the value of the 'id' field */
    public java.lang.Long getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public com.amazonaws.kafka.samples.Event.Builder setId(long value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'id' field */
    public com.amazonaws.kafka.samples.Event.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'date' field */
    public java.lang.CharSequence getDate() {
      return date;
    }
    
    /** Sets the value of the 'date' field */
    public com.amazonaws.kafka.samples.Event.Builder setDate(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.date = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'date' field has been set */
    public boolean hasDate() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'date' field */
    public com.amazonaws.kafka.samples.Event.Builder clearDate() {
      date = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'quantity' field */
    public java.lang.Integer getQuantity() {
      return quantity;
    }
    
    /** Sets the value of the 'quantity' field */
    public com.amazonaws.kafka.samples.Event.Builder setQuantity(int value) {
      validate(fields()[2], value);
      this.quantity = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'quantity' field has been set */
    public boolean hasQuantity() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'quantity' field */
    public com.amazonaws.kafka.samples.Event.Builder clearQuantity() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'unitPrice' field */
    public java.lang.Double getUnitPrice() {
      return unitPrice;
    }
    
    /** Sets the value of the 'unitPrice' field */
    public com.amazonaws.kafka.samples.Event.Builder setUnitPrice(double value) {
      validate(fields()[3], value);
      this.unitPrice = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'unitPrice' field has been set */
    public boolean hasUnitPrice() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'unitPrice' field */
    public com.amazonaws.kafka.samples.Event.Builder clearUnitPrice() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'customerId' field */
    public java.lang.Long getCustomerId() {
      return customerId;
    }
    
    /** Sets the value of the 'customerId' field */
    public com.amazonaws.kafka.samples.Event.Builder setCustomerId(long value) {
      validate(fields()[4], value);
      this.customerId = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'customerId' field has been set */
    public boolean hasCustomerId() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'customerId' field */
    public com.amazonaws.kafka.samples.Event.Builder clearCustomerId() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'country' field */
    public java.lang.CharSequence getCountry() {
      return country;
    }
    
    /** Sets the value of the 'country' field */
    public com.amazonaws.kafka.samples.Event.Builder setCountry(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.country = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'country' field has been set */
    public boolean hasCountry() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'country' field */
    public com.amazonaws.kafka.samples.Event.Builder clearCountry() {
      country = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'description' field */
    public java.lang.CharSequence getDescription() {
      return description;
    }
    
    /** Sets the value of the 'description' field */
    public com.amazonaws.kafka.samples.Event.Builder setDescription(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.description = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'description' field has been set */
    public boolean hasDescription() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'description' field */
    public com.amazonaws.kafka.samples.Event.Builder clearDescription() {
      description = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    public Event build() {
      try {
        Event record = new Event();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Long) defaultValue(fields()[0]);
        record.date = fieldSetFlags()[1] ? this.date : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.quantity = fieldSetFlags()[2] ? this.quantity : (java.lang.Integer) defaultValue(fields()[2]);
        record.unitPrice = fieldSetFlags()[3] ? this.unitPrice : (java.lang.Double) defaultValue(fields()[3]);
        record.customerId = fieldSetFlags()[4] ? this.customerId : (java.lang.Long) defaultValue(fields()[4]);
        record.country = fieldSetFlags()[5] ? this.country : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.description = fieldSetFlags()[6] ? this.description : (java.lang.CharSequence) defaultValue(fields()[6]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
