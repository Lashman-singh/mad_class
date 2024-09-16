package np.com.lashman.calculatorjetpack

sealed class CalculatorOperation(val symbol: String) {
    object Add: CalculatorOperation("+")
    object substract: CalculatorOperation("-")
    object multiply: CalculatorOperation("*")
    object divide: CalculatorOperation("/")
}