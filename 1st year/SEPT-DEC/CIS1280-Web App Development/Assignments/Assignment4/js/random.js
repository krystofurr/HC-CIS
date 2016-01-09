/*

 ##################################################

 Author: Christopher Sigouin
 Date: Oct 24, 2014
 Purpose: Assignment 4 / Part 2 / Tip Calculator
 Dependencies: dice.html, myStyles_Part2.css

 ##################################################

 */

var i = 0; // Array Element Counter
var dieValueArray = []; // Array to hold die values
var ones, twos, threes, fours, fives, sixes; // Counters for each die value
var ARRAY_LIMIT = 19; // Change to increase or decrease array size. This means 0-19 so 20 element spots.

/**
 * rollDie method will use the Math class to store a random number.  It will then set the DIV with the ID of 'results'
 * to the die value.
 * ADDED FUNCTIONALITY: The method will count each time the die is rolled.  Each time it will call the method
 * 'storeDieValue and put the die value into an array. A variable called 'ARRAY_LIMIT' sets the number
 * of values that can be stored. The counter resets upon reaching its limit.
 *
 * @since 10/24/2014
 * @author Christopher Sigouin
 */
function rollDie() {

    var dieValue = Math.floor((Math.random() * 6) + 1);
    document.getElementById("results").innerHTML = "Click to roll again..." + "<br>" +
                                                   "<span id='dieValue'>"+dieValue+"</span><br>";

    /*
        This part below of the rollDie function will store the die roll value into
        an array and continue to add until the array reaches 20 values. It
        will reset once it reaches 20.  This can be changed by the value above
        called ARRAY_LIMIT

     */
    if( i > ARRAY_LIMIT ) {
        i = 0; // Reset the Array Element Counter. Start over
        storeDieValue(dieValue, i); // Store the first value into the array
    } else {
        storeDieValue(dieValue, i); // Store the next value into the array
    }
    i++; // Increment the array element counter
}

/** ADDED FUNCTIONALITY:
 * This method will store the die value into the array and watch to
 * see if the element goes back to 0.  If it does reach 0 then it
 * will reset the array itself and add the die value to the first position
 *
 * @param dieValue
 * @param element
 * @since 10/24/2014
 * @author Christopher Sigouin
 */
function storeDieValue(dieValue, element) {

    // if you see the element is 0 again, reset the array
    if( element == 0 ){
        dieValueArray = []; // Reset the array
        dieValueArray[element] = dieValue; // Store the die value
    } else {
        dieValueArray[element] = dieValue; // Store the die value
    }

    findAverage(dieValueArray); // Call findAverage using the current die value
    return; // Should return to allow rollDie function to increment 'i'
}

/** ADDED FUNCTIONALITY:
 * This method will take the dieValueArray and loop through it's
 * contents looking for all values between 1-6.  It increments
 * seperate counters for each value.  Once it completes the loop,
 * calculations are made on the number of times it finds an instance
 * of the die value and the number of rolls.
 * [ eg. (number of 1s rolled divided by number of rolls) * 100 = the percentage rolled ]
 * It will then output the values as each roll it completed.
 *
 * @param dieValueArray
 * @since 10/24/2014
 * @author Christopher Sigouin
 */
function findAverage(dieValueArray) {

    // Reset all counters before loop starts
    ones = 0;
    twos = 0;
    threes = 0;
    fours = 0;
    fives = 0;
    sixes = 0;

    // loop will run through array and increment counters based on die values in the array
    for( var j=0; j < dieValueArray.length; j++ ) {
        switch(dieValueArray[j]) {
            case 1:
                ones++;
                break;
            case 2:
                twos++;
                break;
            case 3:
                threes++;
                break;
            case 4:
                fours++;
                break;
            case 5:
                fives++;
                break;
            case 6:
                sixes++;
                break;
            default:
                "Nothing to increment"
                break;
        }
    }

    // Calculate percentage on roll values
    var onesPercentage = (ones / dieValueArray.length) * 100;
    var twosPercentage = (twos / dieValueArray.length) * 100;
    var threesPercentage = (threes / dieValueArray.length) * 100;
    var foursPercentage = (fours / dieValueArray.length) * 100;
    var fivesPercentage = (fives / dieValueArray.length) * 100;
    var sixesPercentage = (sixes / dieValueArray.length) * 100;

    // Output the percentage values to the screen
    document.getElementById("percentageValue").innerHTML = "Number of Die Rolls so far: " + dieValueArray.length + "<br><br>" +
                                                           "Percentage of 1s Rolled: " + onesPercentage.toFixed(2) + "%<br>" +
                                                           "Percentage of 2s Rolled: " + twosPercentage.toFixed(2) + "%<br>" +
                                                           "Percentage of 3s Rolled: " + threesPercentage.toFixed(2) + "%<br>" +
                                                           "Percentage of 4s Rolled: " + foursPercentage.toFixed(2) + "%<br>" +
                                                           "Percentage of 5s Rolled: " + fivesPercentage.toFixed(2) + "%<br>" +
                                                           "Percentage of 6s Rolled: " + sixesPercentage.toFixed(2) + "%<br>";
}