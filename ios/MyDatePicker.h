#import <UIKit/UIKit.h>
#import "UIView+React.h"

@interface MyDatePicker : UIDatePicker

@property (nonatomic, copy) RCTBubblingEventBlock onMyChange;

@end
