package fm.qingting.qtradio.view.personalcenter.feedback;

import android.content.Context;
import android.text.Editable;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import fm.qingting.framework.view.ViewGroupViewImpl;
import fm.qingting.qtradio.manager.SkinManager;
import fm.qingting.qtradio.model.SharedCfg;
import fm.qingting.utils.ScreenType;

public class ContactInfoView extends ViewGroupViewImpl
{
  private EditText mEditText;

  public ContactInfoView(Context paramContext)
  {
    super(paramContext);
    this.mEditText = new EditText(paramContext);
    this.mEditText.setBackgroundColor(SkinManager.getBackgroundColor());
    this.mEditText.setTextColor(SkinManager.getTextColorNormal());
    this.mEditText.setHintTextColor(SkinManager.getTextColorSubInfo());
    this.mEditText.setHint("您可以在此留下您的邮箱，手机号码或者qq等联系信息，方便我们与您取得联系");
    this.mEditText.setGravity(51);
    addView(this.mEditText);
    String str = SharedCfg.getInstance().getFeedbackContactInfo();
    this.mEditText.setText(str);
  }

  private boolean closeKeyBoard()
  {
    return ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getApplicationWindowToken(), 0);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mEditText.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.mEditText.measure(paramInt1, paramInt2);
    this.mEditText.setTextSize(0, SkinManager.getInstance().getNormalTextSize());
    int i = ScreenType.getCustomExtraBound();
    this.mEditText.setPadding(i, i, i, i);
    super.onMeasure(paramInt1, paramInt2);
  }

  public void update(String paramString, Object paramObject)
  {
    if (paramString.equalsIgnoreCase("saveInfo"))
    {
      localEditable = this.mEditText.getText();
      if (localEditable != null)
      {
        str = localEditable.toString();
        SharedCfg.getInstance().saveFeedBackContactInfo(str);
      }
    }
    while (!paramString.equalsIgnoreCase("closeKeyboard"))
    {
      Editable localEditable;
      String str;
      return;
    }
    closeKeyBoard();
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.view.personalcenter.feedback.ContactInfoView
 * JD-Core Version:    0.6.2
 */