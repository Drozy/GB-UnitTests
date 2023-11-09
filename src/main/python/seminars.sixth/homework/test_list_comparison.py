"""Тестирование list_comparison"""

import pytest
from model import list_comparison as lc


def test_find_average_typeerror():
    """Юнит-тест, проверяет вывод ошибки, если find_average принимает аргумент неверного типа"""
    with pytest.raises(TypeError):
        lc.find_average("Not a list")


@pytest.mark.parametrize("test_input, expected",
                         [([1, 2, 3, 4, 5], 3),
                          ([-1, -2, -3], -2),
                          ([1, -2, 3, 4], 1.5),
                          ([111, 222, 333, 444], 277.5),
                          ([0, 0, 0], 0),
                          ([1], 1)])
def test_find_average(test_input, expected):
    """Юнит-тест, проверяет результат find_average"""
    assert lc.find_average(test_input) == expected


@pytest.mark.parametrize("test_a, test_b",
                         [([1, 2, 3], "3"),
                          ("Not a list", 22),
                          ("[1, -2, 3, 4]", [111, 222, 333, 444]),
                          ("str", "123")])
def test_compare_typeerror(test_a, test_b):
    """Юнит-тест, проверяет вывод ошибки, если compare принимает аргумент неверного типа"""
    with pytest.raises(TypeError):
        lc.compare(test_a, test_b)


def test_compare_first_bigger():
    """Юнит-тест, проверяет вывод compare, когда первый список имеет большее среднее значение"""
    a = [1, 2, 3, 4, 5]
    b = [1, -2, 3, 4]
    assert lc.compare(a, b) == "Первый список имеет большее среднее значение"


def test_compare_second_bigger():
    """Юнит-тест, проверяет вывод compare, когда второй список имеет большее среднее значение"""
    a = [1, 2, 3, 4, 5]
    b = [111, 222, 333, 444]
    assert lc.compare(a, b) == "Второй список имеет большее среднее значение"


def test_compare_equal():
    """Юнит-тест, проверяет вывод compare, когда средние значения списков равны"""
    a = [1, 2, 3, 4, 5]
    b = [1, -2, 3, 10]
    assert lc.compare(a, b) == "Средние значения равны"
