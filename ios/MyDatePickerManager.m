#import "MyDatePickerManager.h"

@implementation MyDatePickerManager

RCT_EXPORT_MODULE(MyDatePicker)

- (UIView *)view {
  return [[UIDatePicker alloc] init];
}

RCT_EXPORT_VIEW_PROPERTY(date, NSDate)
RCT_CUSTOM_VIEW_PROPERTY(mode, UIDatePickerMode, UIDatePicker){
  UIDatePickerMode pickerMode = UIDatePickerModeDateAndTime;
  view.datePickerMode = pickerMode;
}

@end
