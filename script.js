
function calculate() { 
    let num1 = document.getElementById('num1').value;
    let num2 = document.getElementById('num2').value;
    const operand = document.getElementById('operand').value;
    let result;
    if (operand == "+")  result = num1 + num2;
    else if (operand == "-") result = num1 - num2;
    else if (operand == "/") result = num2 / num2;
    else if (operand == "*") result = num2 * num2;
    else result = 'Select an operand';
    const resultField = document.getElementById('result');
    resultField.value = result;
   
}