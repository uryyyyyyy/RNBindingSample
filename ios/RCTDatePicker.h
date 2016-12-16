#import <UIKit/UIKit.h>
#import "UIView+React.h"

@interface RCTDatePicker : UIDatePicker

@end

@interface RCTDatePicker ()

@property (nonatomic, copy) RCTBubblingEventBlock onMyChange;

@end
