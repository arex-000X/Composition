package com.example.composition.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.composition.R
import com.example.composition.domain.entity.GameResult

@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(
    text: TextView,
    count: Int
) {
    text.text = String.format(
        text.context.getString(R.string.required_score),
        count
    )
}

@BindingAdapter("score")
fun bindScore(
    text: TextView,
    count: Int
) {
    text.text = String
        .format(
            text.context.getString(R.string.score_answers),
            count
        )
}

@BindingAdapter("requiredPercent")
fun bindRequiredPercent(
    text: TextView,
    count: Int
) {
    text.text = String
        .format(
            text.context.getString(R.string.required_percentage),
            count
        )
}

@BindingAdapter("scorePercent")
fun bindScorePercent(
    text: TextView,
    gameResult: GameResult
) {
    text.text = String
        .format(
            text.context.getString(R.string.required_percentage),
            getPrecentOfRightAnswer(gameResult)
        )
}

@BindingAdapter("emojiResult")
fun bindEmojiResult(imageView:ImageView,winner: Boolean){
imageView.setImageResource(getSmileResId(winner))
}
private fun getSmileResId(winner:Boolean): Int {
    return if (winner) {
        R.drawable.ic_smile
    } else {
        R.drawable.ic_sad
    }
}

private fun getPrecentOfRightAnswer(gameResult: GameResult) = with(gameResult) {
    if (countOfQuestions == 0) {
        0
    } else {
        ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
    }
}
