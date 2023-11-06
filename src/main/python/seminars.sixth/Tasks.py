class Tasks:
    # Задание 1
    # @staticmethod
    # def find_average(numbers):
    #     if not numbers:
    #         return 0
    #     return sum(numbers) / len(numbers)

    # Задание 2
    @staticmethod
    def find_average(numbers):
        if not isinstance(numbers, list):
            raise TypeError("Input should be a list.")
        if not numbers:
            return 0
        return sum(numbers) / len(numbers)

    # Задание 3
    class Person:
        def __init__(self, balance=0):
            self.balance = balance

        def transfer_money(self, amount, bank):
            if amount <= 0 or amount > self.balance:
                raise ValueError("Invalid transfer amount")
            self.balance -= amount
            bank.receive_money(amount)

    class Bank:
        def __init__(self):
            self.balance = 0

        def receive_money(self, amount):
            self.balance += amount

    # Задание 5
    @staticmethod
    def divide(a, b):
        if b == 0:
            raise ZeroDivisionError("Cannot divide by zero")
        return a / b

    # Задание 6
    @staticmethod
    def multiply(a, b):
        return a * b

    # Задание 8
    # Запуск проверки с 83 строки
    @staticmethod
    def square(n):
        """
        This function returns the square of a number.
        >>> Tasks.square(5)
        25
        >>> Tasks.square(10)
        100
        >>> Tasks.square(11)
        121
        >>> Tasks.square(2)
        4
        >>> Tasks.square("s")
        Traceback (most recent call last):
        ...
        TypeError: unsupported operand type(s) for ** or pow(): 'str' and 'int'
        >>> Tasks.square(0)
        0
        """
        return n ** 2

    # Задание 9
    @staticmethod
    def is_prime(n):
        """Проверяет, является ли число простым."""
        if n < 2:
            return False
        for i in range(2, int(n ** 0.5) + 1):
            if n % i == 0:
                return False
        return True


if __name__ == '__main__':
    import doctest

    doctest.testmod(verbose=True)
