package com.baseball.Baseball.Teams;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Teams")
public class Team {
    @Id
    public String Id;
    @Field("Name")
    public String Name;
    @Field("Shortname")
    public String Shortname;
    @Field("Path")
    public String Path;
}
