package com.example.macsonuclari.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity()
data class Sonuclar(
    @ColumnInfo
    @SerializedName("AwayTeam")
    val AwayTeam: String,
    @ColumnInfo
    @SerializedName("AwayTeamScore")
    val AwayTeamScore: Int,
    @ColumnInfo
    @SerializedName("DateUtc")
    val DateUtc: String,
    //@ColumnInfo
    //(@SerializedName("Group")
   // val Group : Any,
    @ColumnInfo
    @SerializedName("HomeTeam")
    val HomeTeam: String,
    @ColumnInfo
    @SerializedName("HomeTeamScore")
    val HomeTeamScore: Int,
    @ColumnInfo
    @SerializedName("Location")
    val Location: String,
    @ColumnInfo
    @SerializedName("MatchNumber")
    val MatchNumber: Int,
    @ColumnInfo
    @SerializedName("RoundNumber")
    val RoundNumber: Int
){
    @PrimaryKey(autoGenerate = true)
    var uuid : Int = 0
}