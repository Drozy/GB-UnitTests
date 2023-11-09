"""Тестирование list_comparison"""
from unittest.mock import MagicMock
import pytest

from control import Controller
from user_interface.console_ui import ConsoleUI


def test_input_list_numbers():
    """Проверка вызова функции ввода"""
    ui = ConsoleUI
    ui.ui_input = MagicMock(name='console_input')
    ui.ui_input.return_value = "1 2 3 4"

    Controller(ui).input_list_numbers("message")

    ui.ui_input.assert_called_once_with("message")


def test_input_list_numbers_error():
    """Проверка вызова функции вывода после ввода некорректных значений)"""
    ui = ConsoleUI
    ui.ui_output = MagicMock(name='console_output')
    ui.ui_input = MagicMock(name='console_input')
    ui.ui_input.return_value = "not numbers"

    Controller(ui).input_list_numbers("message")

    ui.ui_output.assert_any_call("Неверный ввод, попробуйте ещё раз.")
    ui.ui_output.assert_called_with("Слишком много попыток, попробуйте позже.")


@pytest.mark.parametrize("data, expected",
                         [("1 2 3 4 5", [1, 2, 3, 4, 5]),
                          ("-1 -2 -3", [-1, -2, -3]),
                          ("1 -2 3 4", [1, -2, 3, 4]),
                          ("1.5 -2.8 3.22 4", [1.5, -2.8, 3.22, 4]),
                          ("1", [1])])
def test_input_list_numbers(data, expected):
    """Проверка корректности преобразования строки в список чисел"""
    ui = ConsoleUI
    ui.ui_input = MagicMock(name='console_input')
    ui.ui_input.return_value = data

    numbers = Controller(ui).input_list_numbers("message")

    assert numbers == expected


def test_start_equal():
    """Тестирование всей программы. Средние значения списков равны"""
    ui = ConsoleUI
    ui.ui_input = MagicMock(name='console_input')
    ui.ui_input.side_effect = ["1 2 3 4 5", "1 -2 3 10"]
    ui.ui_output = MagicMock(name='console_output')

    Controller(ui).start()

    ui.ui_output.assert_called_with("Средние значения равны")


def test_start_first_bigger():
    """Тестирование всей программы. Средние значения списков равны"""
    ui = ConsoleUI
    ui.ui_input = MagicMock(name='console_input')
    ui.ui_input.side_effect = ["1 2 3 4 5", "1 -2 3 4"]
    ui.ui_output = MagicMock(name='console_output')

    Controller(ui).start()

    ui.ui_output.assert_called_with("Первый список имеет большее среднее значение")


def test_start_second_bigger():
    """Тестирование всей программы. Средние значения списков равны"""
    ui = ConsoleUI
    ui.ui_input = MagicMock(name='console_input')
    ui.ui_input.side_effect = ["1 2 3 4 5", "111 222 333 444"]
    ui.ui_output = MagicMock(name='console_output')

    Controller(ui).start()

    ui.ui_output.assert_called_with("Второй список имеет большее среднее значение")
