package com.netlify.aqib.andma;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.core.content.ContextCompat;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * @author Aqib Hamid (paanTom)
 * @version 1.0.0
 * <p>
 * Andma is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with Andma.  If not, see <http://www.gnu.org/licenses/>.
 */

public class Andma {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({DARK,LIGHT})
    @interface Theme{
    }
    public static final int DARK=0;
    public static final int LIGHT=1;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({DEFAULT,SUCCESS,WARNING,INFO,ERROR,CUSTOM})
    @interface Type{
    }
    public static final int CUSTOM=-1;
    public static final int DEFAULT=0;
    public static final int SUCCESS=1;
    public static final int WARNING=2;
    public static final int INFO=3;
    public static final int ERROR=4;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({LONG,SHORT})
    @interface Duration{
    }
    public static final int LONG= Toast.LENGTH_LONG;
    public static final int SHORT=Toast.LENGTH_SHORT;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({TOP,CENTER,BOTTOM})
    @interface Position{
    }
    public static final int BOTTOM= Gravity.BOTTOM;
    public static final int TOP=Gravity.TOP;
    public static final int CENTER=Gravity.CENTER;

    private static Float textSize=12F; //size in sp
    private static final int dark=R.color.DARK;
    private static final int light=R.color.LIGHT;
    private static int textColor= light;
    private static int backgroundColor; //initially 0
    private static int x_offset =0;
    private static int y_offset =90;
    private static Toast toast;
    private static int drawableIcon;
    private static int gravity=BOTTOM;
    private static int duration=SHORT;
    private static int customIcon=0; // used for set custom icon

    private Andma()
    {
        // avoiding instantiation
    }
    /**
     * Shows an Andma with given params.
     * theme can be {DARK,LIGHT}
     * type can be {DEFAULT,SUCCESS,WARNING,INFO,ERROR,CUSTOM}
     */
    public static void show(@NonNull Context context, @NonNull CharSequence message, @Theme int theme, @Type int type){
        setUp(context,message,SHORT,theme,BOTTOM,type);
        toast.show();
    }
    /**
     * Shows an Andma with given params.
     * theme can be {DARK,LIGHT}
     * type can be {DEFAULT,SUCCESS,WARNING,INFO,ERROR,CUSTOM}
     * duration can be {LONG,SHORT}
     */
    public static void show(@NonNull Context context, @NonNull CharSequence message, @Theme int theme, @Type int type, @Duration int duration){
        setUp(context,message,duration,theme,BOTTOM,type);
        toast.show();
    }
    /**
     * Shows an Andma with given params.
     * theme can be {DARK,LIGHT}
     * type can be {DEFAULT,SUCCESS,WARNING,INFO,ERROR,CUSTOM}
     * duration can be {LONG,SHORT}
     * position can be {TOP,CENTER,BOTTOM}
     */
    public static void show(@NonNull Context context, @NonNull CharSequence message, @Theme int theme, @Type int type,  @Duration int duration, @Position int position){
        setUp(context,message,duration,theme,position,type);
        toast.show();
    }
    /**
     * this fun will setup the var with the given params
     */
    private static void setUp(Context context,CharSequence message,int duration,int theme,int gravity,int type){
        View view= LayoutInflater.from(context).inflate(R.layout.andma,null,false);
        TextView text=view.findViewById(R.id.textAndma);
        switch (theme){
            case 0:
                backgroundColor=dark;
                textColor=light;
                break;
            case 1:
                backgroundColor=light;
                textColor=dark;
        }
        switch (type){
            case -1:
                drawableIcon=customIcon;
                view.findViewById(R.id.iconAndma).setVisibility(View.VISIBLE);
                break;
            case 1:
                drawableIcon=R.drawable.andma_success;
                view.findViewById(R.id.iconAndma).setVisibility(View.VISIBLE);
                break;

            case 2:
                drawableIcon=R.drawable.andma_warning;
                view.findViewById(R.id.iconAndma).setVisibility(View.VISIBLE);
                break;
            case 3:
                drawableIcon=R.drawable.andma_info;
                view.findViewById(R.id.iconAndma).setVisibility(View.VISIBLE);
                break;
            case 4:
                drawableIcon=R.drawable.andma_error;
                view.findViewById(R.id.iconAndma).setVisibility(View.VISIBLE);
                break;
        }
        ImageView icon=view.findViewById(R.id.iconAndma);
        icon.setImageResource(drawableIcon);
        view.findViewById(R.id.layout).getBackground().setColorFilter(ContextCompat.getColor(context, backgroundColor), PorterDuff.Mode.SRC_IN);
        text.setText(message);
        text.setTextSize(textSize);
        text.setTextColor(ContextCompat.getColor(context,textColor));
        toast=new Toast(context);
        switch (gravity){
            case CENTER:
                y_offset=0;
                break;
            case TOP:
                y_offset=10;
                break;
        }
        toast.setGravity(gravity, x_offset, y_offset);
        toast.setDuration(duration);
        toast.setView(view);
    }
    public static class Create {

        private Create(){
            // avoiding instantiation
        }
        public static Create custom(){
            return new Create();
        }
        /**
         * Sets the textColor
         * Default val is LIGHT
         */
        public Create setTextColor(@ColorRes int resId)
        {
            Andma.textColor= resId;
            return this;
        }
        /**
         * Sets the backgroundColor
         * Default val is DARK
         */
        public Create setBackgroundColor(@ColorRes int resId){
            Andma.backgroundColor= resId;
            return this;
        }
        /**
         * Sets the textSize
         * Default val is 12sp
         */
        public Create setTextSize(@Size Float size){
            Andma.textSize=size;
            return this;
        }
        /**
         * Sets the x_offset
         * Default val is 0
         */
        public Create setXoffset(int offsetValue){
            Andma.x_offset=offsetValue;
            return this;
        }
        /**
         * Sets the y_offset
         * Default val is 90
         */
        public Create setYoffset(int offsetValue){
            Andma.y_offset=offsetValue;
            return this;
        }
        /**
         * Sets the custom icon
         * Default val is 0
         */
        public Create setDrawableIcon(@DrawableRes int resId){
            Andma.customIcon= resId;
            return this;
        }
        /**
         * Sets the position of Andma
         * Default val is BOTTOM
         */
        public Create setGravity(@Position int position){
            Andma.gravity=position;
            return this;
        }
        /**
         * Sets the duration of Andma
         * Default val is SHORT
         */
        public Create setDuration(@Duration int duration){
            Andma.duration=duration;
            return this;
        }
        /**
         * This fun resets all the vars to default values
         */
        public Create resetAll(){
            Andma.textSize=12F; //size in sp
            Andma.textColor= light;
            Andma.backgroundColor=0;
            Andma.x_offset =0;
            Andma.y_offset =90;
            Andma.customIcon=0; // used for set custom icon
            return this;
        }
        /**
         * Shows an Andma with given params.
         * type can be {DEFAULT,SUCCESS,WARNING,INFO,ERROR,CUSTOM}
         */
        public void show(@NonNull Context context, @NonNull CharSequence message,@Type int type){
            Andma.show(context,message,backgroundColor,type,duration,gravity);
        }
    }
}
