/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, {Component} from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';
import DatePickerIOS from './MyDatePicker';

export default class DatePickerExample extends React.Component {

  state = {date: new Date()};

  onDateChange(date) {
    this.setState({date: date});
  }

  render() {
    return (
      <View>
        <DatePickerIOS
          style={{height: 200}}
          date={this.state.date}
          mode="datetime"
          onDateChange={(date) => this.onDateChange(date)}
        />
        <Text>
          {this.state.date.toString()}
        </Text>
      </View>
    );
  }
}

AppRegistry.registerComponent('RNBindingSample', () => DatePickerExample);
