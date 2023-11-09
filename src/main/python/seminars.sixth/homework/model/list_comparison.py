"""Действия со списками"""


def find_average(a: list):
    """Рассчитывает среднее значение списка."""
    if not isinstance(a, list):
        raise TypeError("Input should be a list.")
    if not a:
        return 0
    return sum(a) / len(a)


def compare(a: list, b: list) -> str:
    """Сравнивает средние значения двух списков и выводит соответствующее сообщение"""
    avg_a = find_average(a)
    avg_b = find_average(b)
    if avg_a > avg_b:
        res = "Первый список имеет большее среднее значение"
    elif avg_a == avg_b:
        res = "Средние значения равны"
    else:
        res = "Второй список имеет большее среднее значение"
    return res
