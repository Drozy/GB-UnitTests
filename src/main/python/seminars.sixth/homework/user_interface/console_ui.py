"""Интерфейс взаимодействия с пользователем"""


class ConsoleUI:
    """Интерфейс взаимодействия с пользователем чререз консоль"""

    @staticmethod
    def ui_output(text: str) -> None:
        """Вывод в консоль"""
        print(text)

    @staticmethod
    def ui_input(message: str) -> str:
        """Ввод с клавиатуры"""
        return input(f"{message}\n")
