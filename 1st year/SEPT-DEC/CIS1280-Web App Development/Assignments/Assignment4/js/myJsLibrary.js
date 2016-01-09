/*

 ##################################################

 Author: Christopher Sigouin
 Date: October 23, 2014
 Purpose: Assignment 4 / Part 1 / Tip Calculator
 Dependencies: myTipCalculator.html, myStyles_Part1.css

 ##################################################

 */

/**
 * calculateTip gets the values from both text fields and stores them in variables.  Error checking is
 * done on both variables to ensure the value is a number.
 *      If
 *          Either of the values is not a number the results field will display a message
 *      Else
 *          It will calculate using both fields for the tipAmount and the totalWithTip.
 *          Once calculated the method will output to the results DIV and format accordingly.
 *
 * @since 10/23/2014
 * @author Christopher Sigouin
 */
function calculateTip() {

    var totalBill = parseFloat(document.getElementById("totalBill").value);
    var tipPercentage = parseFloat(document.getElementById("tipPercentage").value);

    // Test to see if either field is a number
    if (isNaN(totalBill) || isNaN(tipPercentage)) {
        document.getElementById("results").innerHTML = "Valid Number Required!"
    } else {
        // Calculate Tip Amount
        var tipAmount = (totalBill * (tipPercentage/100));
        // Calculate Total Bill with Tip Amount
        var totalWithTip = totalBill + tipAmount;

        // Output it to the 'results' DIV and hide the calculate button
        document.getElementById("calculateButton").style.display = "none";
        document.getElementById("results").style.textAlign = "left";
        document.getElementById("results").innerHTML = "Total Bill Amount: $" + totalBill.toFixed(2) + "<br>" +
                                                       "Tip Percentage: " + tipPercentage + "%" + "<br>" +
                                                       "Total Tip: $" + tipAmount.toFixed(2) + "<br>" +
                                                       "Total Bill with Tip: $" + totalWithTip.toFixed(2) + "<br>" +
                                                       "Current time is: " + formatTime() + "<br><br>" +
                                                       "<button onclick='resetPage()'>Calculate Another?</button>";

    }

}

/**
 * Returns the current time formatted as follows (eg. 9:45am )
 *
 * @since 10/23/2014
 * @author Christopher Sigouin
 */
function formatTime() {

    var d = new Date();
    var hours = d.getHours();
    var minutes = d.getMinutes();
    var amOrPm = "am";

    if( hours > 11 ) { amOrPm = "pm"; }
    if( hours > 12) { hours = hours - 12; }
    if( hours == 0 ) { hours = 12; }
    if ( minutes < 10) { minutes = "0" + minutes; }

    return hours + ":" + minutes + amOrPm;

}

/**
 * Resets the page
 *
 * @since 10/23/2014
 * @author Christopher Sigouin
 */
function resetPage() {
    document.location.reload(true);
}
