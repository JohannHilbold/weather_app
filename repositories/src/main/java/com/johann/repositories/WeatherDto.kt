package com.johann.repositories

import com.squareup.moshi.Json


data class WeatherDto(
    val type: String,
    val geometry: Geometry,
    val properties: Properties
)
data class Geometry(
    val type: String,
    val coordinates: List<Double>
)
data class Properties(
    val meta: Meta,
    @Json(name = "timeseries") val timeSeries: List<TimeSeries>
)
data class Meta(
    @Json(name = "updated_at") val lastUpdated: String,
    val units: Units
)
data class Units(
    @Json(name = "air_pressure_at_sea_level")val airPressureAtSeaLevel: String,
    @Json(name = "air_temperature")val airTemperature: String,
    @Json(name = "cloud_area_fraction")val cloudAreaFraction: String,
    @Json(name = "precipitation_amount")val precipitationAmount: String,
    @Json(name = "relative_humidity")val relativeHumidity: String,
    @Json(name = "wind_from_direction")val windFromDirection: String,
    @Json(name = "wind_speed")val windSpeed: String
)
data class TimeSeries(
    val time: String,
    val data: Data
)
data class Data(
    val instant: Instant,
    @Json(name = "next_12_hours")val next12hours: Next12Hours?,
    @Json(name = "next_1_hours")val next1hours: Next1Hours?,
    @Json(name = "next_6_hours")val next6hours: Next6Hours?
)
data class Instant(
    val details: Details
)
data class Details(
    @Json(name = "air_pressure_at_sea_level")val airPressureAtSeaLevel: Double?,
    @Json(name = "air_temperature")val airTemperature: Double?,
    @Json(name = "cloud_area_fraction")val cloudAreaFraction: Double?,
    @Json(name = "relative_humidity")val relativeHumidity: Double?,
    @Json(name = "wind_from_direction")val windFromDirection: Double?,
    @Json(name = "wind_speed")val windSpeed: Double?
)
data class Next12Hours(
    val summary: Summary,
    val details: Details
)
data class Summary(
    @Json(name = "symbol_code")val symbolCode: String
)
data class Next1Hours(
    val summary: Summary,
    val details: Details
)
data class Next6Hours(
    val summary: Summary,
    val details: Details
)
/*

{

      "type": "Feature",
      "geometry": {
            "type": "Point",
            "coordinates": [
                  9.58,
                  60.1,
                  496
            ]
      },
      "properties": {
            "meta": {
                  "updated_at": "2024-11-15T19:28:50Z",
                  "units": {
                        "air_pressure_at_sea_level": "hPa",
                        "air_temperature": "celsius",
                        "cloud_area_fraction": "%",
                        "precipitation_amount": "mm",
                        "relative_humidity": "%",
                        "wind_from_direction": "degrees",
                        "wind_speed": "m/s"
                  }
            },
            "timeseries": [
                  {
                        "time": "2024-11-15T20:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 1001.4,
                                          "air_temperature": 6.6,
                                          "cloud_area_fraction": 38.9,
                                          "relative_humidity": 89.5,
                                          "wind_from_direction": 176.5,
                                          "wind_speed": 2
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-15T21:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 999.9,
                                          "air_temperature": 6.5,
                                          "cloud_area_fraction": 17.7,
                                          "relative_humidity": 91.1,
                                          "wind_from_direction": 205.6,
                                          "wind_speed": 2.8
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-15T22:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 998.1,
                                          "air_temperature": 6.3,
                                          "cloud_area_fraction": 13.6,
                                          "relative_humidity": 92,
                                          "wind_from_direction": 197.5,
                                          "wind_speed": 2.6
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-15T23:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 997.1,
                                          "air_temperature": 5.9,
                                          "cloud_area_fraction": 21.8,
                                          "relative_humidity": 92.4,
                                          "wind_from_direction": 169.6,
                                          "wind_speed": 2.3
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T00:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 995.6,
                                          "air_temperature": 5.8,
                                          "cloud_area_fraction": 17.6,
                                          "relative_humidity": 93.6,
                                          "wind_from_direction": 151.2,
                                          "wind_speed": 2
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T01:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 995.1,
                                          "air_temperature": 5.9,
                                          "cloud_area_fraction": 62.6,
                                          "relative_humidity": 91.4,
                                          "wind_from_direction": 208.9,
                                          "wind_speed": 1.8
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T02:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 995.1,
                                          "air_temperature": 6.8,
                                          "cloud_area_fraction": 12.5,
                                          "relative_humidity": 63.8,
                                          "wind_from_direction": 260.2,
                                          "wind_speed": 6
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T03:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 994.9,
                                          "air_temperature": 5.1,
                                          "cloud_area_fraction": 0.4,
                                          "relative_humidity": 50.6,
                                          "wind_from_direction": 249.4,
                                          "wind_speed": 6
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T04:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 994.8,
                                          "air_temperature": 4.4,
                                          "cloud_area_fraction": 3.1,
                                          "relative_humidity": 58.9,
                                          "wind_from_direction": 252,
                                          "wind_speed": 4.5
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T05:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 994.3,
                                          "air_temperature": 3.8,
                                          "cloud_area_fraction": 0.4,
                                          "relative_humidity": 43.7,
                                          "wind_from_direction": 254,
                                          "wind_speed": 6.3
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T06:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 993.9,
                                          "air_temperature": 3.2,
                                          "cloud_area_fraction": 0.1,
                                          "relative_humidity": 48.7,
                                          "wind_from_direction": 242.5,
                                          "wind_speed": 5.5
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T07:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 993.6,
                                          "air_temperature": 2.9,
                                          "cloud_area_fraction": 0.2,
                                          "relative_humidity": 48.2,
                                          "wind_from_direction": 237.9,
                                          "wind_speed": 5.1
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T08:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 993.7,
                                          "air_temperature": 2.4,
                                          "cloud_area_fraction": 19.4,
                                          "relative_humidity": 44.8,
                                          "wind_from_direction": 250.5,
                                          "wind_speed": 6.4
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T09:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 993.6,
                                          "air_temperature": 2.2,
                                          "cloud_area_fraction": 27.4,
                                          "relative_humidity": 52.4,
                                          "wind_from_direction": 250.4,
                                          "wind_speed": 4.4
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T10:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 993.3,
                                          "air_temperature": 2.7,
                                          "cloud_area_fraction": 1.9,
                                          "relative_humidity": 45.2,
                                          "wind_from_direction": 253.4,
                                          "wind_speed": 5.9
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T11:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 992.7,
                                          "air_temperature": 3.1,
                                          "cloud_area_fraction": 3.3,
                                          "relative_humidity": 44.2,
                                          "wind_from_direction": 252.7,
                                          "wind_speed": 6.4
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T12:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 991.9,
                                          "air_temperature": 3.5,
                                          "cloud_area_fraction": 2.5,
                                          "relative_humidity": 40.7,
                                          "wind_from_direction": 252.6,
                                          "wind_speed": 7.1
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T13:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 991.5,
                                          "air_temperature": 3.3,
                                          "cloud_area_fraction": 2.6,
                                          "relative_humidity": 45.4,
                                          "wind_from_direction": 249.4,
                                          "wind_speed": 6.6
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T14:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 991,
                                          "air_temperature": 2.8,
                                          "cloud_area_fraction": 4.5,
                                          "relative_humidity": 48.6,
                                          "wind_from_direction": 249.5,
                                          "wind_speed": 5.8
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T15:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 990.1,
                                          "air_temperature": 2.3,
                                          "cloud_area_fraction": 7.9,
                                          "relative_humidity": 45.7,
                                          "wind_from_direction": 249.7,
                                          "wind_speed": 6.8
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T16:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 988.7,
                                          "air_temperature": 2.1,
                                          "cloud_area_fraction": 8.4,
                                          "relative_humidity": 50.1,
                                          "wind_from_direction": 243.8,
                                          "wind_speed": 5.9
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T17:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 987.3,
                                          "air_temperature": 2.3,
                                          "cloud_area_fraction": 2.6,
                                          "relative_humidity": 51.6,
                                          "wind_from_direction": 235.2,
                                          "wind_speed": 5.9
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T18:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 987,
                                          "air_temperature": 2.4,
                                          "cloud_area_fraction": 41.6,
                                          "relative_humidity": 54,
                                          "wind_from_direction": 243,
                                          "wind_speed": 5.4
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T19:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 987.7,
                                          "air_temperature": 2.1,
                                          "cloud_area_fraction": 94.2,
                                          "relative_humidity": 84.6,
                                          "wind_from_direction": 241.2,
                                          "wind_speed": 3.6
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T20:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 987.1,
                                          "air_temperature": 1.9,
                                          "cloud_area_fraction": 12.6,
                                          "relative_humidity": 74,
                                          "wind_from_direction": 233.8,
                                          "wind_speed": 1.6
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T21:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 987,
                                          "air_temperature": 1.3,
                                          "cloud_area_fraction": 40,
                                          "relative_humidity": 75.9,
                                          "wind_from_direction": 238,
                                          "wind_speed": 2.5
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T22:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 986.7,
                                          "air_temperature": 0.9,
                                          "cloud_area_fraction": 11.1,
                                          "relative_humidity": 58.6,
                                          "wind_from_direction": 216.7,
                                          "wind_speed": 2.5
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-16T23:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 986.7,
                                          "air_temperature": 1.1,
                                          "cloud_area_fraction": 0.1,
                                          "relative_humidity": 64.4,
                                          "wind_from_direction": 285.5,
                                          "wind_speed": 2.5
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T00:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 986,
                                          "air_temperature": 0.9,
                                          "cloud_area_fraction": 0.7,
                                          "relative_humidity": 66.3,
                                          "wind_from_direction": 244.2,
                                          "wind_speed": 3.2
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T01:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 985.6,
                                          "air_temperature": 0.8,
                                          "cloud_area_fraction": 2.3,
                                          "relative_humidity": 67.6,
                                          "wind_from_direction": 168.2,
                                          "wind_speed": 2.5
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T02:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 985.5,
                                          "air_temperature": 1,
                                          "cloud_area_fraction": 0.6,
                                          "relative_humidity": 70.5,
                                          "wind_from_direction": 124.7,
                                          "wind_speed": 1.3
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T03:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 984.6,
                                          "air_temperature": 1,
                                          "cloud_area_fraction": 0.8,
                                          "relative_humidity": 72.7,
                                          "wind_from_direction": 65.4,
                                          "wind_speed": 2.2
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T04:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 983.3,
                                          "air_temperature": 1.8,
                                          "cloud_area_fraction": 15,
                                          "relative_humidity": 62.5,
                                          "wind_from_direction": 256.6,
                                          "wind_speed": 3.8
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T05:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 982.4,
                                          "air_temperature": 2.6,
                                          "cloud_area_fraction": 76.4,
                                          "relative_humidity": 49.4,
                                          "wind_from_direction": 299.8,
                                          "wind_speed": 8.4
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T06:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 983.4,
                                          "air_temperature": 2.1,
                                          "cloud_area_fraction": 45.5,
                                          "relative_humidity": 50.6,
                                          "wind_from_direction": 314,
                                          "wind_speed": 5.9
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T07:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 984,
                                          "air_temperature": 2.1,
                                          "cloud_area_fraction": 99.2,
                                          "relative_humidity": 59.4,
                                          "wind_from_direction": 314.9,
                                          "wind_speed": 2.5
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T08:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 984.2,
                                          "air_temperature": 1.9,
                                          "cloud_area_fraction": 99.6,
                                          "relative_humidity": 65.9,
                                          "wind_from_direction": 118.5,
                                          "wind_speed": 1.3
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T09:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 984.8,
                                          "air_temperature": 2.2,
                                          "cloud_area_fraction": 99.9,
                                          "relative_humidity": 66.2,
                                          "wind_from_direction": 94.2,
                                          "wind_speed": 1
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T10:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 985.3,
                                          "air_temperature": 3,
                                          "cloud_area_fraction": 91.4,
                                          "relative_humidity": 72.7,
                                          "wind_from_direction": 48.7,
                                          "wind_speed": 1
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T11:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 986.1,
                                          "air_temperature": 3.6,
                                          "cloud_area_fraction": 46.6,
                                          "relative_humidity": 71,
                                          "wind_from_direction": 37.3,
                                          "wind_speed": 1.3
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T12:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 986.6,
                                          "air_temperature": 4,
                                          "cloud_area_fraction": 53.8,
                                          "relative_humidity": 70.2,
                                          "wind_from_direction": 352.3,
                                          "wind_speed": 1.7
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T13:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 987.1,
                                          "air_temperature": 4.2,
                                          "cloud_area_fraction": 87.6,
                                          "relative_humidity": 60.8,
                                          "wind_from_direction": 325.9,
                                          "wind_speed": 2.6
                                    }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T14:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 987.9,
                                          "air_temperature": 4,
                                          "cloud_area_fraction": 90.9,
                                          "relative_humidity": 54.4,
                                          "wind_from_direction": 333.7,
                                          "wind_speed": 2.9
                                    }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T15:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 988.7,
                                          "air_temperature": 3,
                                          "cloud_area_fraction": 99.5,
                                          "relative_humidity": 61.1,
                                          "wind_from_direction": 344.9,
                                          "wind_speed": 1.6
                                    }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T16:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 989.6,
                                          "air_temperature": 2,
                                          "cloud_area_fraction": 99.5,
                                          "relative_humidity": 67.2,
                                          "wind_from_direction": 1.1,
                                          "wind_speed": 1.9
                                    }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T17:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 990.3,
                                          "air_temperature": 1.7,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 65.3,
                                          "wind_from_direction": 35.1,
                                          "wind_speed": 2.2
                                    }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T18:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 990.6,
                                          "air_temperature": 1.5,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 63.6,
                                          "wind_from_direction": 17.8,
                                          "wind_speed": 2.2
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T19:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 991.3,
                                          "air_temperature": 1.3,
                                          "cloud_area_fraction": 99.9,
                                          "relative_humidity": 66.2,
                                          "wind_from_direction": 311.8,
                                          "wind_speed": 2.9
                                    }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T20:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 991.8,
                                          "air_temperature": 1.1,
                                          "cloud_area_fraction": 99.7,
                                          "relative_humidity": 61.8,
                                          "wind_from_direction": 311.9,
                                          "wind_speed": 3.1
                                    }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T21:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 992.7,
                                          "air_temperature": 0.7,
                                          "cloud_area_fraction": 98.3,
                                          "relative_humidity": 61.6,
                                          "wind_from_direction": 314.4,
                                          "wind_speed": 2.7
                                    }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T22:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 993.5,
                                          "air_temperature": 0.3,
                                          "cloud_area_fraction": 96,
                                          "relative_humidity": 66,
                                          "wind_from_direction": 338.2,
                                          "wind_speed": 2.2
                                    }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-17T23:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 994,
                                          "air_temperature": 0.1,
                                          "cloud_area_fraction": 72.9,
                                          "relative_humidity": 69.3,
                                          "wind_from_direction": 338.8,
                                          "wind_speed": 2.1
                                    }
                              },
                              "next_1_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-18T00:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 994.5,
                                          "air_temperature": -0.1,
                                          "cloud_area_fraction": 8.4,
                                          "relative_humidity": 70.5,
                                          "wind_from_direction": 348.2,
                                          "wind_speed": 1.9
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-18T06:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 994.5,
                                          "air_temperature": -0.9,
                                          "cloud_area_fraction": 99.2,
                                          "relative_humidity": 75.6,
                                          "wind_from_direction": 291.1,
                                          "wind_speed": 2.4
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-18T12:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 996.4,
                                          "air_temperature": 1,
                                          "cloud_area_fraction": 99.2,
                                          "relative_humidity": 67.1,
                                          "wind_from_direction": 293.6,
                                          "wind_speed": 1.2
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-18T18:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 997.1,
                                          "air_temperature": -2.2,
                                          "cloud_area_fraction": 93.7,
                                          "relative_humidity": 82.5,
                                          "wind_from_direction": 291.8,
                                          "wind_speed": 1.9
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-19T00:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 997,
                                          "air_temperature": -3.2,
                                          "cloud_area_fraction": 12.5,
                                          "relative_humidity": 79.8,
                                          "wind_from_direction": 292.3,
                                          "wind_speed": 1.7
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-19T06:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 996.9,
                                          "air_temperature": -4.6,
                                          "cloud_area_fraction": 43.7,
                                          "relative_humidity": 83.8,
                                          "wind_from_direction": 304.1,
                                          "wind_speed": 1.3
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-19T12:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 996.7,
                                          "air_temperature": -2,
                                          "cloud_area_fraction": 95.3,
                                          "relative_humidity": 64.2,
                                          "wind_from_direction": 32,
                                          "wind_speed": 1.6
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "lightsnow"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-19T18:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 993.3,
                                          "air_temperature": -2.2,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 81.9,
                                          "wind_from_direction": 25.6,
                                          "wind_speed": 2.8
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "snow"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "snow"
                                    },
                                    "details": {
                                          "precipitation_amount": 2.3
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-20T00:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 988.8,
                                          "air_temperature": -1.9,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 83.6,
                                          "wind_from_direction": 20.7,
                                          "wind_speed": 4.2
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "snow"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "snow"
                                    },
                                    "details": {
                                          "precipitation_amount": 3.5
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-20T06:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 987.1,
                                          "air_temperature": -1.9,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 84.1,
                                          "wind_from_direction": 16.9,
                                          "wind_speed": 4.5
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "snow"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "snow"
                                    },
                                    "details": {
                                          "precipitation_amount": 3.7
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-20T12:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 986.5,
                                          "air_temperature": -1.8,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 83.1,
                                          "wind_from_direction": 19.1,
                                          "wind_speed": 5
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "snow"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "snow"
                                    },
                                    "details": {
                                          "precipitation_amount": 3
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-20T18:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 982,
                                          "air_temperature": -1.2,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 84.5,
                                          "wind_from_direction": 18.1,
                                          "wind_speed": 4.8
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "snow"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "snow"
                                    },
                                    "details": {
                                          "precipitation_amount": 2.3
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-21T00:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 985,
                                          "air_temperature": -2.3,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 80.6,
                                          "wind_from_direction": 337.2,
                                          "wind_speed": 4.6
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "snow"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "snow"
                                    },
                                    "details": {
                                          "precipitation_amount": 1.6
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-21T06:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 982.9,
                                          "air_temperature": -2.6,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 80.1,
                                          "wind_from_direction": 335.2,
                                          "wind_speed": 4.3
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "lightsnow"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "snow"
                                    },
                                    "details": {
                                          "precipitation_amount": 1.5
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-21T12:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 980.5,
                                          "air_temperature": -2.8,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 83.1,
                                          "wind_from_direction": 344.6,
                                          "wind_speed": 3.3
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-21T18:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 981.4,
                                          "air_temperature": -3.7,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 77.8,
                                          "wind_from_direction": 338.6,
                                          "wind_speed": 2.8
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-22T00:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 980.6,
                                          "air_temperature": -4.7,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 79.7,
                                          "wind_from_direction": 302.5,
                                          "wind_speed": 2.5
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-22T06:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 982.6,
                                          "air_temperature": -5.8,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 78.2,
                                          "wind_from_direction": 300,
                                          "wind_speed": 2.2
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-22T12:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 985,
                                          "air_temperature": -4.7,
                                          "cloud_area_fraction": 97.7,
                                          "relative_humidity": 69,
                                          "wind_from_direction": 335.2,
                                          "wind_speed": 1.4
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-22T18:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 984.4,
                                          "air_temperature": -6.6,
                                          "cloud_area_fraction": 99.2,
                                          "relative_humidity": 80.7,
                                          "wind_from_direction": 302.4,
                                          "wind_speed": 1.9
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-23T00:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 987.1,
                                          "air_temperature": -6.7,
                                          "cloud_area_fraction": 41.4,
                                          "relative_humidity": 79.5,
                                          "wind_from_direction": 298.7,
                                          "wind_speed": 1.8
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-23T06:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 990.9,
                                          "air_temperature": -7.5,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 83.1,
                                          "wind_from_direction": 299,
                                          "wind_speed": 1.8
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-23T12:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 991.7,
                                          "air_temperature": -5.5,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 72,
                                          "wind_from_direction": 302.2,
                                          "wind_speed": 0.9
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-23T18:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 997.2,
                                          "air_temperature": -6.3,
                                          "cloud_area_fraction": 88.3,
                                          "relative_humidity": 81,
                                          "wind_from_direction": 300.5,
                                          "wind_speed": 1.8
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-24T00:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 1000.6,
                                          "air_temperature": -6.8,
                                          "cloud_area_fraction": 2.3,
                                          "relative_humidity": 81,
                                          "wind_from_direction": 300.4,
                                          "wind_speed": 1.7
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "clearsky_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-24T06:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 1002.4,
                                          "air_temperature": -9.4,
                                          "cloud_area_fraction": 31.2,
                                          "relative_humidity": 82.1,
                                          "wind_from_direction": 303.8,
                                          "wind_speed": 1.4
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-24T12:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 1002.5,
                                          "air_temperature": -7,
                                          "cloud_area_fraction": 30.1,
                                          "relative_humidity": 68.9,
                                          "wind_from_direction": 296.6,
                                          "wind_speed": 0.7
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_day"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-24T18:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 1004.1,
                                          "air_temperature": -9.1,
                                          "cloud_area_fraction": 16.4,
                                          "relative_humidity": 82,
                                          "wind_from_direction": 304.8,
                                          "wind_speed": 1.4
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "fair_night"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-25T00:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 1005.4,
                                          "air_temperature": -10.2,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 82.3,
                                          "wind_from_direction": 302,
                                          "wind_speed": 1.7
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-25T06:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 1000.9,
                                          "air_temperature": -6,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 85.3,
                                          "wind_from_direction": 306.6,
                                          "wind_speed": 1.6
                                    }
                              },
                              "next_12_hours": {
                                    "summary": {
                                          "symbol_code": "partlycloudy_day"
                                    },
                                    "details": { }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-25T12:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 1002.6,
                                          "air_temperature": -5.6,
                                          "cloud_area_fraction": 100,
                                          "relative_humidity": 78.5,
                                          "wind_from_direction": 333.9,
                                          "wind_speed": 1.1
                                    }
                              },
                              "next_6_hours": {
                                    "summary": {
                                          "symbol_code": "cloudy"
                                    },
                                    "details": {
                                          "precipitation_amount": 0
                                    }
                              }
                        }
                  },
                  {
                        "time": "2024-11-25T18:00:00Z",
                        "data": {
                              "instant": {
                                    "details": {
                                          "air_pressure_at_sea_level": 1003.7,
                                          "air_temperature": -5.1,
                                          "cloud_area_fraction": 14.5,
                                          "relative_humidity": 81.1,
                                          "wind_from_direction": 302.3,
                                          "wind_speed": 1.7
                                    }
                              }
                        }
                  }
            ]
      }

}

 */
