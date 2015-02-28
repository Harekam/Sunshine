package com.weather.harek.sunshine.app.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataParser {

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
       JSONObject jsonObject=new JSONObject(weatherJsonStr);
        JSONArray jsonArray=jsonObject.getJSONArray("list");
        JSONObject day=jsonArray.getJSONObject(dayIndex);
        JSONObject temp=day.getJSONObject("temp");
        Double maxTemp=temp.getDouble("max");

        return maxTemp;
    }

}
