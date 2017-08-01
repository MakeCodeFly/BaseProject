package com.zoujuequn.baseproject.ui;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.base.BaseActivity;
import com.zoujuequn.baseproject.widget.SpannyTextView;


public class SpanyActivity extends BaseActivity {
    @Override
    public int bindLayout() {
        return R.layout.activity_spany;
    }

    @Override
    public void initView(View parentView) {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        TextView textView = (TextView) parentView.findViewById(R.id.textView);
        SpannyTextView spanny = new SpannyTextView("StyleSpan\n", new StyleSpan(Typeface.BOLD_ITALIC))
                .append("\nUnderlineSpan, ", new UnderlineSpan())
                .append(" TypefaceSpan, ", new TypefaceSpan("serif"))
                .append("URLSpan, ", new URLSpan("google.com"))
                .append("StrikethroughSpan", new StrikethroughSpan())
                .append("\nQuoteSpan", new QuoteSpan(Color.RED))
                .append("\nPlain text")
                .append("SubscriptSpan", new SubscriptSpan())
                .append("SuperscriptSpan", new SuperscriptSpan())
                .append("\n\nBackgroundSpan", new BackgroundColorSpan(Color.LTGRAY))
                .append("\n\nForegroundColorSpan", new ForegroundColorSpan(Color.LTGRAY))
                .append("\nAlignmentSpan", new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER))
                .append("\nTextAppearanceSpan\n", new TextAppearanceSpan(this, android.R.style.TextAppearance_Medium))
                .append("ImageSpan", new ImageSpan(getApplicationContext(), R.mipmap.ic_launcher))
                .append("\nRelativeSizeSpan", new RelativeSizeSpan(1.5f))
                .append("\n好弄吧来得及发了附近")
                .append("\n\nMultiple spans", new StyleSpan(Typeface.ITALIC), new UnderlineSpan(),
                        new TextAppearanceSpan(this, android.R.style.TextAppearance_Large),
                        new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), new BackgroundColorSpan(Color.LTGRAY));
        textView.setText(spanny);

        spanny = new SpannyTextView("\n\nFind and span the word. All appearances of the word will be spanned.");
        spanny.findAndSpan("word", new SpannyTextView.GetSpan() {
            @Override public Object getSpan() {
                return new UnderlineSpan();
            }
        });
        textView.append(spanny);
    }

    private int dp(int value) {
        return (int) Math.ceil(getResources().getDisplayMetrics().density * value);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void widgetClick(View v) {

    }
}
