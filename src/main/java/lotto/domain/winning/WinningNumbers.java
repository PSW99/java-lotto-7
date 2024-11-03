package lotto.domain.winning;

import lotto.validator.WinningValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        this.winningNumbers = validateAndConvertWinningNumbers(winningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private List<Integer> validateAndConvertWinningNumbers(String winningNumbers) {
        WinningValidator.validateIsNumericWithCommas(winningNumbers);
        List<Integer> numbers = convertStringToIntList(winningNumbers);
        WinningValidator.validateWinningNumberCount(numbers);
        WinningValidator.validateAllNumbersInRange(numbers);
        WinningValidator.validateNoDuplicates(numbers);

        return numbers;
    }

    public static List<Integer> convertStringToIntList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}