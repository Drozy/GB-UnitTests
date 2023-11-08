"""Интерфейс взаимодействия с пользователем"""
__all__ = ["output", "input_list"]


def output(text: str) -> None:
    """Вывод в консоль"""
    print(text)


def input_list(message: str) -> list:
    """Ввод списка чисел с клавиатуры"""
    while True:
        user_list = input(f"{message}\n").split()
        try:
            user_list[:] = list(map(float, user_list))
            break
        except ValueError:
            print("Неверный ввод, попробуйте ещё раз.")
    return user_list
