"""
Программа принимает два списка чисел и выполняет следующие действия:
a. Рассчитывает среднее значение каждого списка.
b. Сравнивает эти средние значения и выводит соответствующее сообщение:
- "Первый список имеет большее среднее значение", если среднее значение первого списка больше.
- "Второй список имеет большее среднее значение", если среднее значение второго списка больше.
- "Средние значения равны", если средние значения списков равны.
"""

from user_interface import console_ui
from model import list_comparison


class Controller:
    """controller"""

    def __init__(self, interface: console_ui):
        self.interface = interface

    def input_list_numbers(self, message: str) -> list:
        """Преобразует строку в список чисел"""
        i = 0
        numbers = []
        while i < 10:
            try:
                data = self.interface.ui_input(message).split()
                numbers = list(map(float, data))
                if numbers:
                    break
            except ValueError:
                self.interface.ui_output("Неверный ввод, попробуйте ещё раз.")
            i += 1
        if i == 10:
            self.interface.ui_output("Слишком много попыток, попробуйте позже.")
        return numbers

    def start(self):
        a = self.input_list_numbers("Введите первый список чисел через пробел:")
        b = self.input_list_numbers("Введите второй список чисел через пробел:")
        self.interface.ui_output(list_comparison.compare(a, b))


if __name__ == '__main__':
    Controller(console_ui.ConsoleUI).start()
