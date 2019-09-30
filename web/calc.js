function myFunction() {
    var tempHeight = document.getElementById('height').value;
    var tempWeight = document.getElementById('weight').value;
    var feetAndInches = tempHeight.split(".");
    var weight = parseFloat(tempWeight) * 0.453592;
    var feet = parseInt(feetAndInches[0]);
    var feetToInches = feet * 12;
    var inchesRemaining = parseInt(feetAndInches[1]);
    var totalFeet = feetToInches + inchesRemaining;
    var heightInMetrics = totalFeet * 0.0254;
    console.log(heightInMetrics);
    console.log(weight);
    var bmi = weight/(heightInMetrics * heightInMetrics);
    document.getElementById('calculate').innerHTML = "<h2> Your BMI is <b><br>" + bmi + "</b></h2>";
}