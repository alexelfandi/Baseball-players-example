package com.baseball.Baseball.Players;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Players")
public class Player {
    @Id
    public String id;
    @Field("Name")
    public String Name;
    @Field("Team")
    public String Team;
    @Field("Position")
    public String Position;
    @Field("Height")
    public Double Height;
    @Field("Weight")
    public Double Weight;
    @Field("Age")
    public Double Age;


}
