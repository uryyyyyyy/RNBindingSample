#import "RCTDatePickerManager.h"

#import "RCTBridge.h"
#import "RCTDatePicker.h"

@implementation RCTConvert(UIDatePicker)

RCT_ENUM_CONVERTER(UIDatePickerMode, (@{
                                        @"time": @(UIDatePickerModeTime),
                                        @"date": @(UIDatePickerModeDate),
                                        @"datetime": @(UIDatePickerModeDateAndTime),
                                        @"countdown": @(UIDatePickerModeCountDownTimer), // not supported yet
                                        }), UIDatePickerModeTime, integerValue)

@end

@implementation RCTDatePickerManager

RCT_EXPORT_MODULE(MyDatePicker)

- (UIView *)view
{
  return [[RCTDatePicker alloc] init];
}

RCT_EXPORT_VIEW_PROPERTY(date, NSDate)
RCT_EXPORT_VIEW_PROPERTY(onMyChange, RCTBubblingEventBlock)
RCT_REMAP_VIEW_PROPERTY(mode, datePickerMode, UIDatePickerMode)

@end
