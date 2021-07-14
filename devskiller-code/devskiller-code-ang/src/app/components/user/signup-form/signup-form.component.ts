import {Component, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {EventEmitter} from 'events';

interface SignUpRequest {
  username: string;
  password: string;
  email: string;
}

@Component({
  selector: 'signup-form',
  templateUrl: './signup-form.component.html',
  styleUrls: ['./signup-form.component.css']
})
export class SignupFormComponent implements OnInit {

  f: FormGroup;

  @Output() save  = new EventEmitter();

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    const passwordPattern = '^(?=.*?[A-Z])(?=.*?[0-9]).{8,}$';

    this.f = this.formBuilder.group({
        username: ['', [Validators.required]],
        email: ['', Validators.compose([Validators.required, Validators.email])],
        password: ['', Validators.compose([Validators.required, Validators.pattern(passwordPattern)])],
        password_match: ['', Validators.compose( [Validators.required, Validators.pattern(passwordPattern)])],
    },
      {
        validators: this.checkPasswordsMath
      });
  }

  checkPasswordsMath(group: FormGroup) {
    const password = group.get('password').value;
    const confirmPassword = group.get('password_match').value;

    return password === confirmPassword ? null : {notSamePassword: true};
  }

  signup() {
    if (this.f.valid) {
      const result = {...this.f.value};
      delete result.password_match;
      this.save.emit(result);
    }
  }

}
