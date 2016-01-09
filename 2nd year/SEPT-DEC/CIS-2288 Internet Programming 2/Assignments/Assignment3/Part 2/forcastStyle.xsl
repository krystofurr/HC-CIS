<?xml version="1.0"?>

<!--

 ____            _     ____            _____                            _
|  _ \ __ _ _ __| |_  |___ \          |  ___|__  _ __ ___  ___ __ _ ___| |_
| |_) / _` | '__| __|   __) |  _____  | |_ / _ \| '__/ _ \/ __/ _` / __| __|
|  __/ (_| | |  | |_   / __/  |_____| |  _| (_) | | |  __/ (_| (_| \__ \ |_
|_|   \__,_|_|   \__| |_____|         |_|  \___/|_|  \___|\___\__,_|___/\__|


    Program name:       Assignment 3 - Part 2
    Author:             Christopher Sigouin
    Version:            1.0
    Description:        Styled forecast sheet to match a provided image
    Dependencies:       n/a
    Database file:      n/a
    Change History:     2015.11.04 Original version by CJS

-->


<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <style>

                   .degrees {
                        font-style: italic;
                   }

                    table {
                        width: 50%;
                        border-collapse: separate;
                    }

                    table, td {
                        border: 1px solid black;
                    }

                    td {
                        vertical-align: text-top;
                    }

                    img {
                        /* If changed to a percentage, the output is strange */
                        max-width: 100px;
                        height: auto;

                    }

                    .highLowTemps {
                        margin-bottom: 20px;
                    }

                    .grayTopBorder {
                        padding-top: 10px;
                        border-top: 3px solid #D7D7D7;
                    }

                </style>
            </head>
            <body>
                <h1>Forecast for <xsl:value-of select="forecast/location/city"/>, <xsl:value-of select="forecast/location/province"/>, <xsl:value-of select="forecast/location/country"/></h1>
                <h2 class="degrees">Degrees in <xsl:value-of select="forecast/location/degrees"/></h2>
                <h2>Five day forecast</h2>

                <table>
                    <tr>
                        <!-- Loop through each day element -->
                        <xsl:for-each select="forecast/daily/day">
                            <td>
                                <xsl:value-of select="date"/>
                                <br/>

                                <!-- Choose each image element to provide based on the condition element -->
                                <xsl:choose>
                                    <xsl:when test="condition = 'sun-cloud'">
                                        <img alt="sun-cloud" src="images/sun-cloud.jpg" />
                                    </xsl:when>
                                    <xsl:when test="condition = 'rain'">
                                        <img alt="rain" src="images/rain.jpg" />
                                    </xsl:when>
                                    <xsl:when test="condition = 'overcast'">
                                        <img alt="overcast" src="images/overcast.jpg" />
                                    </xsl:when>
                                    <xsl:when test="condition = 'snow'">
                                        <img alt="snow" src="images/snow.jpg" />
                                    </xsl:when>
                                    <xsl:when test="condition = 'sun'">
                                        <img alt="sun" src="images/sun.jpg" />
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <img alt="sun" src="images/lightning.jpg" />
                                    </xsl:otherwise>
                                </xsl:choose>

                                <!-- Output and style high and low elements -->
                                <div class="highLowTemps">
                                    High: <xsl:value-of select="high"/>
                                    <br/>
                                    Low: <xsl:value-of select="low"/>
                                </div>

                                <!-- Output and style the description -->
                                <div class="grayTopBorder">
                                    <xsl:value-of select="description"/>
                                </div>
                            </td>
                        </xsl:for-each>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>



