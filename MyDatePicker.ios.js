'use strict';

const PropTypes = require('react/lib/ReactPropTypes');
const React = require('React');
const StyleSheet = require('StyleSheet');
const View = require('View');

const requireNativeComponent = require('requireNativeComponent');

class DatePickerIOS extends React.Component {

  _onChange(event) {
    this.props.onDateChange(new Date(event.nativeEvent.timestamp));
  }

  render() {
    return (
      <RCTDatePickerIOS
        style={this.props.style}
        date={this.props.date.getTime()}
        mode={this.props.mode}
        onMyChange={this._onChange.bind(this)}
      />
    );
  }
}

DatePickerIOS.propTypes = {
  //style: ...View.propTypes.style,
  date: PropTypes.instanceOf(Date).isRequired,
  onDateChange: PropTypes.func.isRequired,
  mode: PropTypes.oneOf(['date', 'time', 'datetime'])
};

const RCTDatePickerIOS = requireNativeComponent('RCTDatePicker', {
  propTypes: {
    date: PropTypes.number,
    mode: PropTypes.oneOf(['date', 'time', 'datetime']),
    onMyChange: PropTypes.func,
  }
});

module.exports = DatePickerIOS;