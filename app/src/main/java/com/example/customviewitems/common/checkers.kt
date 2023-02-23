package com.example.customviewitems.common


fun isValidEmail(email: String): String? {

    return if (android.util.Patterns.EMAIL_ADDRESS.matcher(email.trim())
            .matches() && email.isNotEmpty()
    ) {
        null
    } else {
        "ემაილი არ არის ვალიდური"
    }
}

fun isValidPassword(password: String): String? {

    if (password.length < 8) return "შეიყვანთ მინიმუმ 8 სიმბოლო"
    if (password.filter { it.isDigit() }.firstOrNull() == null) return "შეიყვანეთ მინიმუმ 1 ციფრი"
    if (password.filter { it.isLetter() }.filter { it.isUpperCase() }
            .firstOrNull() == null) return "შეიყვანეთ მინინუმ 1 დიდი სიმბოლო"
    if (password.filter { it.isLetter() }.filter { it.isLowerCase() }
            .firstOrNull() == null) return "შეიყვანეთ მინიმუმ 1 პატარა სიმბოლო"
    if (password.filter { !it.isLetterOrDigit() }
            .firstOrNull() == null) return "შეიყვანეთ სპეციალური სიმბოლბო ( #,+,%,& და ა.შ.)"

    return null
}

fun isValidRepeatPassword(repeatPassword: String, password: String): String? {

    return if (password == repeatPassword) {
        null
    } else {
        "პაროლები არ ემთხვევა"
    }
}

